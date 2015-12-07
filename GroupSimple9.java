package nudt.codes.gsimple;

import me.lemire.compress.IntWrapper;
import me.lemire.compress.IntegerCODEC;

/**
 * 双simple9 81种情况,为了保证足够的压缩序列长度
 * 
 */

public final class GroupSimple9 implements IntegerCODEC {

	// 两个selector的组合形成的编码
	private static final int[][] M = { { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, { 9, 10, 11, 12, 13, 14, 15, 16, 17 },
			{ 18, 19, 20, 21, 22, 23, 24, 25, 26 }, { 27, 28, 29, 30, 31, 32, 33, 34, 35 },
			{ 36, 37, 38, 39, 40, 41, 42, 43, 44 }, { 45, 46, 47, 48, 49, 50, 51, 52, 53 },
			{ 54, 55, 56, 57, 58, 59, 60, 61, 62 }, { 63, 64, 65, 66, 67, 68, 69, 70, 71 },
			{ 72, 73, 74, 75, 76, 77, 78, 79, 80 } };

	@Override
	public void compress(int[] tmpinput, IntWrapper inpos, int inlength, int out[], IntWrapper outpos) {
		int[] in = new int[inlength + 27];
		for (int i = 0; i < in.length; i++) {
			if (i < inlength)
				in[i] = tmpinput[i];
			else
				in[i] = 0;
		}
		int tmpoutpos = outpos.get();
		int currentPos = inpos.get();
		int selector1 = 0;
		int selector2 = 0;
		out[tmpoutpos++] = inlength;
		outpos.add(1);
		final int finalin = currentPos + inlength;
		while (currentPos < finalin) {
			mainloop: for (; selector1 <= 8; selector1++) {
				int compressedNum = codeNum[selector1];
				if (finalin <= currentPos + compressedNum - 1)
					compressedNum = finalin - currentPos;
				int b = bitLength[selector1];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++) {
					if (max <= in[currentPos + i])
						continue mainloop;
				}
				currentPos += compressedNum;
				break;
			}
			mainloop: for (; selector2 <= 8; selector2++) {
				int compressedNum = codeNum[selector2];
				if (finalin <= currentPos + compressedNum - 1)
					compressedNum = finalin - currentPos;
				int b = bitLength[selector2];
				int max = 1 << b;
				int i = 0;
				for (; i < compressedNum; i++) {
					if (max <= in[currentPos + i])
						continue mainloop;
				}
				currentPos += compressedNum;
				break;
			}

			int code = M[selector1][selector2];
			switch (code) {
			case 0:
				encode0(in, inpos, code, out, outpos);
				break;
			case 1:
				encode1(in, inpos, code, out, outpos);
				break;
			case 2:
				encode2(in, inpos, code, out, outpos);
				break;
			case 3:
				encode3(in, inpos, code, out, outpos);
				break;
			case 4:
				encode4(in, inpos, code, out, outpos);
				break;
			case 5:
				encode5(in, inpos, code, out, outpos);
				break;
			case 6:
				encode6(in, inpos, code, out, outpos);
				break;
			case 7:
				encode7(in, inpos, code, out, outpos);
				break;
			case 8:
				encode8(in, inpos, code, out, outpos);
				break;
			case 9:
				encode9(in, inpos, code, out, outpos);
				break;
			case 10:
				encode10(in, inpos, code, out, outpos);
				break;
			case 11:
				encode11(in, inpos, code, out, outpos);
				break;
			case 12:
				encode12(in, inpos, code, out, outpos);
				break;
			case 13:
				encode13(in, inpos, code, out, outpos);
				break;
			case 14:
				encode14(in, inpos, code, out, outpos);
				break;
			case 15:
				encode15(in, inpos, code, out, outpos);
				break;
			case 16:
				encode16(in, inpos, code, out, outpos);
				break;
			case 17:
				encode17(in, inpos, code, out, outpos);
				break;
			case 18:
				encode18(in, inpos, code, out, outpos);
				break;
			case 19:
				encode19(in, inpos, code, out, outpos);
				break;
			case 20:
				encode20(in, inpos, code, out, outpos);
				break;
			case 21:
				encode21(in, inpos, code, out, outpos);
				break;
			case 22:
				encode22(in, inpos, code, out, outpos);
				break;
			case 23:
				encode23(in, inpos, code, out, outpos);
				break;
			case 24:
				encode24(in, inpos, code, out, outpos);
				break;
			case 25:
				encode25(in, inpos, code, out, outpos);
				break;
			case 26:
				encode26(in, inpos, code, out, outpos);
				break;
			case 27:
				encode27(in, inpos, code, out, outpos);
				break;
			case 28:
				encode28(in, inpos, code, out, outpos);
				break;
			case 29:
				encode29(in, inpos, code, out, outpos);
				break;
			case 30:
				encode30(in, inpos, code, out, outpos);
				break;
			case 31:
				encode31(in, inpos, code, out, outpos);
				break;
			case 32:
				encode32(in, inpos, code, out, outpos);
				break;
			case 33:
				encode33(in, inpos, code, out, outpos);
				break;
			case 34:
				encode34(in, inpos, code, out, outpos);
				break;
			case 35:
				encode35(in, inpos, code, out, outpos);
				break;
			case 36:
				encode36(in, inpos, code, out, outpos);
				break;
			case 37:
				encode37(in, inpos, code, out, outpos);
				break;
			case 38:
				encode38(in, inpos, code, out, outpos);
				break;
			case 39:
				encode39(in, inpos, code, out, outpos);
				break;
			case 40:
				encode40(in, inpos, code, out, outpos);
				break;
			case 41:
				encode41(in, inpos, code, out, outpos);
				break;
			case 42:
				encode42(in, inpos, code, out, outpos);
				break;
			case 43:
				encode43(in, inpos, code, out, outpos);
				break;
			case 44:
				encode44(in, inpos, code, out, outpos);
				break;
			case 45:
				encode45(in, inpos, code, out, outpos);
				break;
			case 46:
				encode46(in, inpos, code, out, outpos);
				break;
			case 47:
				encode47(in, inpos, code, out, outpos);
				break;
			case 48:
				encode48(in, inpos, code, out, outpos);
				break;
			case 49:
				encode49(in, inpos, code, out, outpos);
				break;
			case 50:
				encode50(in, inpos, code, out, outpos);
				break;
			case 51:
				encode51(in, inpos, code, out, outpos);
				break;
			case 52:
				encode52(in, inpos, code, out, outpos);
				break;
			case 53:
				encode53(in, inpos, code, out, outpos);
				break;
			case 54:
				encode54(in, inpos, code, out, outpos);
				break;
			case 55:
				encode55(in, inpos, code, out, outpos);
				break;
			case 56:
				encode56(in, inpos, code, out, outpos);
				break;
			case 57:
				encode57(in, inpos, code, out, outpos);
				break;
			case 58:
				encode58(in, inpos, code, out, outpos);
				break;
			case 59:
				encode59(in, inpos, code, out, outpos);
				break;
			case 60:
				encode60(in, inpos, code, out, outpos);
				break;
			case 61:
				encode61(in, inpos, code, out, outpos);
				break;
			case 62:
				encode62(in, inpos, code, out, outpos);
				break;
			case 63:
				encode63(in, inpos, code, out, outpos);
				break;
			case 64:
				encode64(in, inpos, code, out, outpos);
				break;
			case 65:
				encode65(in, inpos, code, out, outpos);
				break;
			case 66:
				encode66(in, inpos, code, out, outpos);
				break;
			case 67:
				encode67(in, inpos, code, out, outpos);
				break;
			case 68:
				encode68(in, inpos, code, out, outpos);
				break;
			case 69:
				encode69(in, inpos, code, out, outpos);
				break;
			case 70:
				encode70(in, inpos, code, out, outpos);
				break;
			case 71:
				encode71(in, inpos, code, out, outpos);
				break;
			case 72:
				encode72(in, inpos, code, out, outpos);
				break;
			case 73:
				encode73(in, inpos, code, out, outpos);
				break;
			case 74:
				encode74(in, inpos, code, out, outpos);
				break;
			case 75:
				encode75(in, inpos, code, out, outpos);
				break;
			case 76:
				encode76(in, inpos, code, out, outpos);
				break;
			case 77:
				encode77(in, inpos, code, out, outpos);
				break;
			case 78:
				encode78(in, inpos, code, out, outpos);
				break;
			case 79:
				encode79(in, inpos, code, out, outpos);
				break;
			case 80:
				encode80(in, inpos, code, out, outpos);
				break;
			}//end switch
			inpos.set(currentPos);
		}

	}

	private void encode0(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + (0xFF & in[inf + i]);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode1(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode2(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 28 + i];// 第二个28位是低位存储的，所以浪费的1比特在最顶端。
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode3(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode4(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode5(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode6(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode7(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode8(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 24; i++)
			out[outf + 0] = (out[outf + 0] << 1) + in[inf + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 24 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 28 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode9(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode10(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode11(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode12(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode13(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode14(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode15(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode16(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode17(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 12; i++)
			out[outf + 0] = (out[outf + 0] << 2) + in[inf + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 12 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 14 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode18(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode19(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode20(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode21(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode22(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode23(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode24(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode25(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode26(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 8; i++)
			out[outf + 0] = (out[outf + 0] << 3) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 8 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 9 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode27(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode28(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode29(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode30(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode31(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode32(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode33(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode34(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode35(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 6; i++)
			out[outf + 0] = (out[outf + 0] << 4) + in[inf + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 6 + i];
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 7 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode36(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode37(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode38(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode39(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode40(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode41(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode42(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode43(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode44(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 4; i++)
			out[outf + 0] = (out[outf + 0] << 5) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 4) + (in[inf + 4] >>> 1);
		out[outf + 1] = (out[outf + 1] << 1) + ((in[inf + 4] << 31) >>> 31);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 5 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode45(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode46(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode47(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode48(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode49(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode50(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode51(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode52(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode53(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 3; i++)
			out[outf + 0] = (out[outf + 0] << 7) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 3) + (in[inf + 3] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 3] << 28) >>> 28);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 4 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode54(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode55(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode56(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode57(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode58(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode59(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode60(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode61(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode62(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		for (int i = 0; i < 2; i++)
			out[outf + 0] = (out[outf + 0] << 9) + in[inf + i];
		out[outf + 0] = (out[outf + 0] << 6) + (in[inf + 2] >>> 3);
		out[outf + 1] = (out[outf + 1] << 3) + ((in[inf + 2] << 29) >>> 29);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 3 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode63(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();

		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode64(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode65(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode66(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode67(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode68(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode69(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode70(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode71(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 14) + in[inf];
		out[outf + 0] = (out[outf + 0] << 10) + (in[inf + 1] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf + 1] << 28) >>> 28);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 2 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode72(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();

		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 28; i++)
			out[outf + 1] = (out[outf + 1] << 1) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode73(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 14; i++)
			out[outf + 1] = (out[outf + 1] << 2) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode74(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 9; i++)
			out[outf + 1] = (out[outf + 1] << 3) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode75(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 7; i++)
			out[outf + 1] = (out[outf + 1] << 4) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode76(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 5; i++)
			out[outf + 1] = (out[outf + 1] << 5) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode77(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 4; i++)
			out[outf + 1] = (out[outf + 1] << 7) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode78(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 3; i++)
			out[outf + 1] = (out[outf + 1] << 9) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode79(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 2; i++)
			out[outf + 1] = (out[outf + 1] << 14) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	private void encode80(final int[] in, final IntWrapper inOffset, final int code, final int[] out,
			final IntWrapper outOffset) {
		int inf = inOffset.get();
		int outf = outOffset.get();
		out[outf + 0] = (out[outf + 0] << 24) + (in[inf] >>> 4);
		out[outf + 1] = (out[outf + 1] << 4) + ((in[inf] << 28) >>> 28);
		for (int i = 0; i < 1; i++)
			out[outf + 1] = (out[outf + 1] << 28) + in[inf + 1 + i];
		out[outf + 0] = code << 24 | out[outf + 0];
		outOffset.add(2);
	}

	@Override
	public void uncompress(int[] in, IntWrapper inpos, int inlength, int[] out, IntWrapper outpos) {
		int currentPos = outpos.get();
		int tmpinpos = inpos.get();
		final int finalout = currentPos + in[tmpinpos++];
		while (currentPos < finalout) {
			int val = in[tmpinpos++];
			int valn = in[tmpinpos++];
			int header = val >>> 24;
			switch (header) {
			case 0: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = valn >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 1: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31;// 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = valn >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 2: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;// 头部1bit
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				out[currentPos++] = (valn << 4) >>> 31;
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 3: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = valn >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 4: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;// 头部3bit
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 5: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = valn >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 6: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				out[currentPos++] = (valn << 4) >>> 31;
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 7: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = valn >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 8: { // number : 28, bitwidth : 1
				out[currentPos++] = (val << 8) >>> 31;
				out[currentPos++] = (val << 9) >>> 31;
				out[currentPos++] = (val << 10) >>> 31;
				out[currentPos++] = (val << 11) >>> 31;
				out[currentPos++] = (val << 12) >>> 31;
				out[currentPos++] = (val << 13) >>> 31; // 10
				out[currentPos++] = (val << 14) >>> 31;
				out[currentPos++] = (val << 15) >>> 31;
				out[currentPos++] = (val << 16) >>> 31;
				out[currentPos++] = (val << 17) >>> 31;
				out[currentPos++] = (val << 18) >>> 31;
				out[currentPos++] = (val << 19) >>> 31;
				out[currentPos++] = (val << 20) >>> 31;
				out[currentPos++] = (val << 21) >>> 31;
				out[currentPos++] = (val << 22) >>> 31;
				out[currentPos++] = (val << 23) >>> 31; // 20
				out[currentPos++] = (val << 24) >>> 31;
				out[currentPos++] = (val << 25) >>> 31;
				out[currentPos++] = (val << 26) >>> 31;
				out[currentPos++] = (val << 27) >>> 31;
				out[currentPos++] = (val << 28) >>> 31;
				out[currentPos++] = (val << 29) >>> 31;
				out[currentPos++] = (val << 30) >>> 31;
				out[currentPos++] = (val << 31) >>> 31;
				out[currentPos++] = valn >>> 31;
				out[currentPos++] = (valn << 1) >>> 31;
				out[currentPos++] = (valn << 2) >>> 31;
				out[currentPos++] = (valn << 3) >>> 31;
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 9: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 0) >>> 30;
				out[currentPos++] = (valn << 2) >>> 30;
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 10: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 0) >>> 30;
				out[currentPos++] = (valn << 2) >>> 30;
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 11: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 1) >>> 30;
				out[currentPos++] = (valn << 3) >>> 30;
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 12: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 0) >>> 30;
				out[currentPos++] = (valn << 2) >>> 30;
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 13: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 3) >>> 30;
				out[currentPos++] = (valn << 5) >>> 30;
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 14: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 0) >>> 30;
				out[currentPos++] = (valn << 2) >>> 30;
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 15: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 1) >>> 30;
				out[currentPos++] = (valn << 3) >>> 30;
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 16: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 0) >>> 30;
				out[currentPos++] = (valn << 2) >>> 30;
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 17: { // number : 14, bitwidth : 2
				out[currentPos++] = (val << 8) >>> 30;
				out[currentPos++] = (val << 10) >>> 30;
				out[currentPos++] = (val << 12) >>> 30;
				out[currentPos++] = (val << 14) >>> 30;
				out[currentPos++] = (val << 16) >>> 30;
				out[currentPos++] = (val << 18) >>> 30;
				out[currentPos++] = (val << 20) >>> 30;
				out[currentPos++] = (val << 22) >>> 30; // 10
				out[currentPos++] = (val << 24) >>> 30;
				out[currentPos++] = (val << 26) >>> 30;
				out[currentPos++] = (val << 28) >>> 30;
				out[currentPos++] = (val << 30) >>> 30;
				out[currentPos++] = (valn << 0) >>> 30;
				out[currentPos++] = (valn << 2) >>> 30;
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 18: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 1) >>> 29;
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 19: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 1) >>> 29;
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 20: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 2) >>> 29;
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 21: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 1) >>> 29;
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 22: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 4) >>> 29;
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 23: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 1) >>> 29;
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 24: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 2) >>> 29;
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 25: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 1) >>> 29;
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 26: { // number : 9, bitwidth : 3
				out[currentPos++] = (val << 8) >>> 29;
				out[currentPos++] = (val << 11) >>> 29;
				out[currentPos++] = (val << 14) >>> 29;
				out[currentPos++] = (val << 17) >>> 29;
				out[currentPos++] = (val << 20) >>> 29;
				out[currentPos++] = (val << 23) >>> 29;
				out[currentPos++] = (val << 26) >>> 29;
				out[currentPos++] = (val << 29) >>> 29;
				out[currentPos++] = (valn << 1) >>> 29;
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 27: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 0) >>> 28;
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 28: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 0) >>> 28;
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 29: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 1) >>> 28;
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}

			case 30: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 0) >>> 28;
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 31: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 3) >>> 28;
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 32: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 0) >>> 28;
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 33: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 1) >>> 28;
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 34: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 0) >>> 28;
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 35: { // number : 7, bitwidth : 4
				out[currentPos++] = (val << 8) >>> 28;
				out[currentPos++] = (val << 12) >>> 28;
				out[currentPos++] = (val << 16) >>> 28;
				out[currentPos++] = (val << 20) >>> 28;
				out[currentPos++] = (val << 24) >>> 28;
				out[currentPos++] = (val << 28) >>> 28;
				out[currentPos++] = (valn << 0) >>> 28;
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 36: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 37: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 38: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 27);
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 39: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 40: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 25);
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 41: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 42: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 27);
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 43: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 44: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 27;
				out[currentPos++] = (val << 13) >>> 27;
				out[currentPos++] = (val << 18) >>> 27;
				out[currentPos++] = (val << 23) >>> 27;
				out[currentPos++] = (val << 28) >>> 27 | (valn >>> 28);
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 45: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 46: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 47: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 27);
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 48: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 49: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 25);
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 50: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 51: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 27);
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 52: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 53: { // number : 4, bitwidth : 7
				out[currentPos++] = (val << 8) >>> 25;
				out[currentPos++] = (val << 15) >>> 25;
				out[currentPos++] = (val << 22) >>> 25;
				out[currentPos++] = (val << 29) >>> 25 | (valn >>> 28);
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 54: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 55: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 56: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 27);
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 57: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 58: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 25);
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 59: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 60: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 27);
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 61: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 62: { // number : 3, bitwidth : 9
				out[currentPos++] = (val << 8) >>> 23;
				out[currentPos++] = (val << 17) >>> 23;
				out[currentPos++] = (val << 26) >>> 23 | (valn >>> 28);
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 63: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 64: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 65: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 27);
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 66: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 67: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 25);
				// number : 5, bitwidth : 5
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 68: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 69: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 27);
				// number : 3, bitwidth : 9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 70: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
				// number : 2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 71: { // number : 2, bitwidth : 14
				out[currentPos++] = (val << 8) >>> 18;
				out[currentPos++] = (val << 22) >>> 18 | (valn >>> 28);
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			case 72: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
				// number : 28, bitwidth : 1
				out[currentPos++] = (valn << 4) >>> 31;
				out[currentPos++] = (valn << 5) >>> 31;
				out[currentPos++] = (valn << 6) >>> 31;
				out[currentPos++] = (valn << 7) >>> 31;
				out[currentPos++] = (valn << 8) >>> 31;
				out[currentPos++] = (valn << 9) >>> 31;
				out[currentPos++] = (valn << 10) >>> 31;
				out[currentPos++] = (valn << 11) >>> 31;
				out[currentPos++] = (valn << 12) >>> 31;
				out[currentPos++] = (valn << 13) >>> 31; // 10
				out[currentPos++] = (valn << 14) >>> 31;
				out[currentPos++] = (valn << 15) >>> 31;
				out[currentPos++] = (valn << 16) >>> 31;
				out[currentPos++] = (valn << 17) >>> 31;
				out[currentPos++] = (valn << 18) >>> 31;
				out[currentPos++] = (valn << 19) >>> 31;
				out[currentPos++] = (valn << 20) >>> 31;
				out[currentPos++] = (valn << 21) >>> 31;
				out[currentPos++] = (valn << 22) >>> 31;
				out[currentPos++] = (valn << 23) >>> 31; // 20
				out[currentPos++] = (valn << 24) >>> 31;
				out[currentPos++] = (valn << 25) >>> 31;
				out[currentPos++] = (valn << 26) >>> 31;
				out[currentPos++] = (valn << 27) >>> 31;
				out[currentPos++] = (valn << 28) >>> 31;
				out[currentPos++] = (valn << 29) >>> 31;
				out[currentPos++] = (valn << 30) >>> 31;
				out[currentPos++] = (valn << 31) >>> 31;
				break;
			}
			case 73: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 4) >>> 30;
				out[currentPos++] = (valn << 6) >>> 30;
				out[currentPos++] = (valn << 8) >>> 30;
				out[currentPos++] = (valn << 10) >>> 30;
				out[currentPos++] = (valn << 12) >>> 30;
				out[currentPos++] = (valn << 14) >>> 30;
				out[currentPos++] = (valn << 16) >>> 30;
				out[currentPos++] = (valn << 18) >>> 30;
				out[currentPos++] = (valn << 20) >>> 30;
				out[currentPos++] = (valn << 22) >>> 30; // 10
				out[currentPos++] = (valn << 24) >>> 30;
				out[currentPos++] = (valn << 26) >>> 30;
				out[currentPos++] = (valn << 28) >>> 30;
				out[currentPos++] = (valn << 30) >>> 30;
				break;
			}
			case 74: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 27);
				// number : 9, bitwidth : 3
				out[currentPos++] = (valn << 5) >>> 29;
				out[currentPos++] = (valn << 8) >>> 29;
				out[currentPos++] = (valn << 11) >>> 29;
				out[currentPos++] = (valn << 14) >>> 29;
				out[currentPos++] = (valn << 17) >>> 29;
				out[currentPos++] = (valn << 20) >>> 29;
				out[currentPos++] = (valn << 23) >>> 29;
				out[currentPos++] = (valn << 26) >>> 29;
				out[currentPos++] = (valn << 29) >>> 29;
				break;
			}
			case 75: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
				// number : 7, bitwidth : 4
				out[currentPos++] = (valn << 4) >>> 28;
				out[currentPos++] = (valn << 8) >>> 28;
				out[currentPos++] = (valn << 12) >>> 28;
				out[currentPos++] = (valn << 16) >>> 28;
				out[currentPos++] = (valn << 20) >>> 28;
				out[currentPos++] = (valn << 24) >>> 28;
				out[currentPos++] = (valn << 28) >>> 28;
				break;
			}
			case 76: { // number : 5, bitwidth : 5
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 25);
				// number : 14, bitwidth : 2
				out[currentPos++] = (valn << 7) >>> 27;
				out[currentPos++] = (valn << 12) >>> 27;
				out[currentPos++] = (valn << 17) >>> 27;
				out[currentPos++] = (valn << 22) >>> 27;
				out[currentPos++] = (valn << 27) >>> 27;
				break;
			}
			case 77: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
				// number : 4, bitwidth : 7
				out[currentPos++] = (valn << 4) >>> 25;
				out[currentPos++] = (valn << 11) >>> 25;
				out[currentPos++] = (valn << 18) >>> 25;
				out[currentPos++] = (valn << 25) >>> 25;
				break;
			}
			case 78: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 27);
				// number : 3, bitwidth :9
				out[currentPos++] = (valn << 5) >>> 23;
				out[currentPos++] = (valn << 14) >>> 23;
				out[currentPos++] = (valn << 23) >>> 23;
				break;
			}
			case 79: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
				// number :2, bitwidth : 14
				out[currentPos++] = (valn << 4) >>> 18;
				out[currentPos++] = (valn << 18) >>> 18;
				break;
			}
			case 80: { // number : 1, bitwidth : 28
				out[currentPos++] = (val << 8) >>> 4 | (valn >>> 28);
				// number : 1, bitwidth : 28
				out[currentPos++] = (valn << 4) >>> 4;
				break;
			}
			default:
				throw new RuntimeException("Wrong code: " + header);
			}// end switch
		} // end while
		outpos.set(finalout);
		inpos.set(tmpinpos);
	}

	private final static int bitLength[] = { 1, 2, 3, 4, 5, 7, 9, 14, 28 };

	private final static int codeNum[] = { 28, 14, 9, 7, 5, 4, 3, 2, 1 };

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	public static void main(String args[]) {
		IntWrapper inpos = new IntWrapper();
		IntWrapper outpos = new IntWrapper();
		inpos.set(0);
		outpos.set(0);
		int input[] = new int[65535];

		for (int i = 0; i < input.length; i++) {
			input[i] = i;
		}

		int output[] = new int[input.length];
		int outputput[] = new int[input.length + 27];

		int outputWord = 0;// the length of the output
		GroupSimple9 sd = new GroupSimple9();
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
