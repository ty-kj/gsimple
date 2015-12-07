/*
 * Copyright 2014 Matteo Catena
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nudt.codes.gvint;

import me.lemire.compress.IntWrapper;
import me.lemire.compress.IntegerCODEC;

/**
 * A Java implementation of groupvarint, described by J.Dean in
 * "Challenges in Building Large-Scale Information Retrieval Systems" at WSDM'09
 * 
 * @author Matteo Catena
 * 
 */
public class GroupVarint implements IntegerCODEC {

	private EncodeFunctions encodeFunctions;
	private DecodeFunctions decodeFunctions;

	public GroupVarint() {

		encodeFunctions = new EncodeFunctions();
		decodeFunctions = new DecodeFunctions();

	}

	/**
	 * Compress an int array into a byte array
	 * 
	 * @param in
	 *            the uncompressed int array (origin)
	 * @param inOffset
	 *            {@code in} starting offset
	 * @param length
	 *            the number of ints to be compressed, starting from
	 *            {@code inOffset}
	 * @param out
	 *            the compressed byte array (destination)
	 * @param outOffset
	 *            {@code out} starting offset
	 * @return 
	 * @return new offset in out[]
	 * 
	 */
	@Override
	public void compress(int[] in, IntWrapper inpos, int length, int[] out, IntWrapper outpos) {
		int inOffset=inpos.get();
		int outOffset=outpos.get();
		final int cond = length / 4 * 4;
		out[0]=length;
		outOffset++;
		while (inOffset < cond) {

			outOffset += encodeFunctions.encode(in, inOffset, out, outOffset);
			inOffset += 4;
		}

		for (int i = 0; i < length - cond; i++) {
			encodeFunctions.writeUncompressedInt(in[i + inOffset], out, outOffset);
			outOffset += 4;
		}
		outpos.set(outOffset);
		inpos.set(inOffset);

	}

	/**
	 * Uncompress a byte array into an int array
	 * 
	 * @param in
	 *            the compressed byte array (origin)
	 * @param inOffset
	 *            {@code in} starting offset
	 * @param out
	 *            the uncompressed int array (destination)
	 * @param outOffset
	 *            {@code out} starting offset
	 * @param length
	 *            number of uncompressed ints
	 * @return new offset in in[]
	 */
	@Override
	public void uncompress(int[] in, IntWrapper inpos, int length, int[] out, IntWrapper outpos) {
		int inOffset=inpos.get();
		int outOffset=outpos.get();
		int decodelength= in[0];
		inOffset++;
		final int cond = decodelength / 4 * 4;
		while (outOffset < cond) {

			int code = 0xFF & in[inOffset++];
			inOffset += decodeFunctions.decode(in, inOffset, code, out, outOffset);
			outOffset += 4;
		}

		for (int i = 0; i < decodelength - cond; i++) {

			out[outOffset++] = decodeFunctions.readUncompressedInt(in, inOffset);
			inOffset += 4;
		}
		outpos.set(outOffset);
		inpos.set(inOffset);
	}

	/**
	 * This method estimates the length of the compressed byte array
	 * 
	 * @param num
	 *            Number of ints in the uncompressed int array
	 * @return Upperbound on the number of bytes in the compressed byte array
	 */
	public static final int getSafeCompressedLength(int num) {

		return (num * 4) + (num / 4) + 12;
	}

    @Override
    public String toString() {
            return this.getClass().getSimpleName();
    }
    
	public static void main(String args[]) {
		IntWrapper inpos = new IntWrapper();
		IntWrapper outpos = new IntWrapper();
		inpos.set(0);
		outpos.set(0);
		int input[] = new int[34];

		for (int i = 0; i < input.length; i++) {
			input[i] = i;
		}

		int output[] = new int[input.length+1024];
		int outputput[] = new int[input.length];

		int outputWord = 0;// the length of the output
		GroupVarint sd = new GroupVarint();
		sd.compress(input, inpos, input.length, output, outpos);
		outputWord = outpos.get();
		System.out.println("length " + outputWord);
		inpos.set(0);
		outpos.set(0);
		long beforeDecompress = System.nanoTime() / 1000;
		sd.uncompress(output, inpos, outputWord, outputput, outpos);
		long afterDecompress = System.nanoTime() / 1000;
		System.out.println(afterDecompress - beforeDecompress);
	}
}
