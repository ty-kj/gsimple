package nudt.codes.simple;

import me.lemire.compress.IntWrapper;
import me.lemire.compress.IntegerCODEC;

/**
 * This is the enhanced simpleX compression method, which keeps the use of
 * original code mode when the suited integers are larger than the that the next
 * mode can accommodate . Example: 1, 1, ... , 1, 28 (27 1s and 1 28), it is not
 * suited for the code mode (28*1). However, the number of suited integers is
 * 27, it is larger than the size of the mode (14*2).
 */

// another implementation of SimpleD
public final class SimpleD3 implements IntegerCODEC {
	@Override
	public void compress(int[] in, IntWrapper inpos, int inlength, int out[],
			IntWrapper outpos) {
		int tmpoutpos = outpos.get();
		int currentPos = inpos.get();
		out[tmpoutpos++] = inlength;
		int finalpos = currentPos + inlength;
		outer: while (currentPos < finalpos) {
			mainloop: for (int selector = 0; selector < 8; selector++) {
				int res = 0;
				int compressedNum = codeNum[selector];
				if (finalpos <= currentPos + compressedNum - 1)
					compressedNum = finalpos - currentPos;
				int b = bitLength[selector];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++) {
					if (max <= in[currentPos + i]) {
						if (i > codeNum[selector + 1]) {
							// 如果能容纳的数字个数多于下一个模式所能容纳的数字
							compressedNum = i;
							break;
						} else
							continue mainloop;
					}
					res = (res << b) + in[currentPos + i];
				}
				// 末尾补零
				if (compressedNum != codeNum[selector])
					res <<= (codeNum[selector] - compressedNum) * b;
				res |= selector << 28;
				out[tmpoutpos++] = res;
				currentPos += compressedNum;
				continue outer;
			}
			final int selector = 8;
			if (in[currentPos] >= 1 << bitLength[selector])
				throw new RuntimeException("Too big a number");
			out[tmpoutpos++] = in[currentPos++] | (selector << 28);
		}
		outpos.set(tmpoutpos);
	}

	@Override
	public void uncompress(int[] coded, IntWrapper inpos, int inlength,
			int[] recovered, IntWrapper outpos) {
		int currentPos = outpos.get();
		int tmpinpos = inpos.get();
		final int finalout = currentPos + coded[tmpinpos++];

		while (currentPos < finalout) {
			int val = coded[tmpinpos++];
			int header = val >>> 28;
			switch (header) {
			case 0: { // number : 28, bitwidth : 1
				recovered[currentPos++] = (val << 4) >>> 31;
				recovered[currentPos++] = (val << 5) >>> 31;
				recovered[currentPos++] = (val << 6) >>> 31;
				recovered[currentPos++] = (val << 7) >>> 31;
				recovered[currentPos++] = (val << 8) >>> 31;
                recovered[currentPos++] = (val << 9) >>> 31;
                recovered[currentPos++] = (val << 10) >>> 31;
                recovered[currentPos++] = (val << 11) >>> 31;
                recovered[currentPos++] = (val << 12) >>> 31;
                recovered[currentPos++] = (val << 13) >>> 31; // 10
                recovered[currentPos++] = (val << 14) >>> 31;
                recovered[currentPos++] = (val << 15) >>> 31;
                recovered[currentPos++] = (val << 16) >>> 31;
                recovered[currentPos++] = (val << 17) >>> 31;
                recovered[currentPos++] = (val << 18) >>> 31;
                recovered[currentPos++] = (val << 19) >>> 31;
                recovered[currentPos++] = (val << 20) >>> 31;
                recovered[currentPos++] = (val << 21) >>> 31;
                recovered[currentPos++] = (val << 22) >>> 31;
                recovered[currentPos++] = (val << 23) >>> 31; // 20
                recovered[currentPos++] = (val << 24) >>> 31;
                recovered[currentPos++] = (val << 25) >>> 31;
                recovered[currentPos++] = (val << 26) >>> 31;
                recovered[currentPos++] = (val << 27) >>> 31;
                recovered[currentPos++] = (val << 28) >>> 31;
                recovered[currentPos++] = (val << 29) >>> 31;
                recovered[currentPos++] = (val << 30) >>> 31;
                recovered[currentPos++] = (val << 31) >>> 31;
                currentPos-=zeroNum(val);//remove the 0s
				break;
			}
			case 1: { // number : 14, bitwidth : 2
				recovered[currentPos++] = (val << 4) >>> 30;
				recovered[currentPos++] = (val << 6) >>> 30;
				recovered[currentPos++] = (val << 8) >>> 30;
				recovered[currentPos++] = (val << 10) >>> 30;
				recovered[currentPos++] = (val << 12) >>> 30;
				recovered[currentPos++] = (val << 14) >>> 30;
				recovered[currentPos++] = (val << 16) >>> 30;
				recovered[currentPos++] = (val << 18) >>> 30;
				recovered[currentPos++] = (val << 20) >>> 30;
				recovered[currentPos++] = (val << 22) >>> 30; // 10
				recovered[currentPos++] = (val << 24) >>> 30;
				recovered[currentPos++] = (val << 26) >>> 30;
				recovered[currentPos++] = (val << 28) >>> 30;
				recovered[currentPos++] = (val << 30) >>> 30;
				currentPos-=zeroNum(val) / 2;//remove the 0s
				break;
			}
			case 2: { // number : 9, bitwidth : 3
				recovered[currentPos++] = (val << 5) >>> 29;
				recovered[currentPos++] = (val << 8) >>> 29;
				recovered[currentPos++] = (val << 11) >>> 29;
				recovered[currentPos++] = (val << 14) >>> 29;
				recovered[currentPos++] = (val << 17) >>> 29;
				recovered[currentPos++] = (val << 20) >>> 29;
				recovered[currentPos++] = (val << 23) >>> 29;
				recovered[currentPos++] = (val << 26) >>> 29;
				recovered[currentPos++] = (val << 29) >>> 29;
				currentPos-=zeroNum(val) /3;
				break;
			}
			case 3: { // number : 7, bitwidth : 4
				recovered[currentPos++] = (val << 4) >>> 28;
				recovered[currentPos++] = (val << 8) >>> 28;
				recovered[currentPos++] = (val << 12) >>> 28;
				recovered[currentPos++] = (val << 16) >>> 28;
				recovered[currentPos++] = (val << 20) >>> 28;
				recovered[currentPos++] = (val << 24) >>> 28;
				recovered[currentPos++] = (val << 28) >>> 28;
				currentPos-=zeroNum(val) /4;
				break;
			}
			case 4: { // number : 5, bitwidth : 5
				recovered[currentPos++] = (val << 7) >>> 27;
				recovered[currentPos++] = (val << 12) >>> 27;
				recovered[currentPos++] = (val << 17) >>> 27;
				recovered[currentPos++] = (val << 22) >>> 27;
				recovered[currentPos++] = (val << 27) >>> 27;
				currentPos-=zeroNum(val) /5;
				break;
			}
			case 5: { // number : 4, bitwidth : 7
				recovered[currentPos++] = (val << 4) >>> 25;
				recovered[currentPos++] = (val << 11) >>> 25;
				recovered[currentPos++] = (val << 18) >>> 25;
				recovered[currentPos++] = (val << 25) >>> 25;
				currentPos-=zeroNum(val) /7;
				break;
			}
			case 6: { // number : 3, bitwidth : 9
				recovered[currentPos++] = (val << 5) >>> 23;
                recovered[currentPos++] = (val << 14) >>> 23;
                recovered[currentPos++] = (val << 23) >>> 23;
				currentPos-=zeroNum(val) /9;
				break;
			}
			case 7: { // number : 2, bitwidth : 14
				recovered[currentPos++] = (val << 4) >>> 18;
				recovered[currentPos++] = (val << 18) >>> 18;
				currentPos-=zeroNum(val) /14;
				break;
			}
			case 8: { // number : 1, bitwidth : 28
				recovered[currentPos++] = (val << 4) >>> 4;
				break;
			}
			default: {
				throw new RuntimeException("shouldn't happen");
			}
			}
		}
		outpos.set(currentPos);
		inpos.set(tmpinpos);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	private static int zeroNum(int number) {
		return multiplyDeBruijnBitPosition[((number & -number) * 0x077CB531) >>> 27];
	}

	private final static int bitLength[] = { 1, 2, 3, 4, 5, 7, 9, 14, 28 };

	private final static int codeNum[] = { 28, 14, 9, 7, 5, 4, 3, 2, 1 };

	private static final int[] multiplyDeBruijnBitPosition = { 0, 1, 28, 2, 29,
			14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19,
			16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };

}
