package com.zero.stock.util;

/**
 * 获取首字母 目前使用了无字典的方式 ，若发现bug做记录，并换成字典库的方式(pinyin4j.jar)
 * 
 * @author ghost
 * @since 2018.8.22
 */
public class PinyinConverter {
	public static String getPinyinIntial(String strChinese) {
		try {
			StringBuffer buffer = new StringBuffer();
			byte b[] = strChinese.getBytes("GBK");// 把中文转化成byte数组
			for (int i = 0; i < b.length; i++) {
				if ((b[i] & 255) > 128) {
					int char1 = b[i++] & 255;
					char1 <<= 8;// 左移运算符用“<<”表示，是将运算符左边的对象，向左移动运算符右边指定的位数，并且在低位补零。其实，向左移n位，就相当于乘上2的n次方
					int chart = char1 + (b[i] & 255);
					buffer.append(getPYChar(chart));
					continue;
				}
				buffer.append((char) b[i]);
				/*
				 * char c = (char) b[i]; if (!Character.isJavaIdentifierPart(c))// 确定指定字符是否可以是
				 * Java标识符中首字符以外的部分。 c = 'A';
				 */
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strChinese + "!wrong";
	}

	public static char getPYChar(int codePoint) {
		int i = codePoint;

		if (i < 0xB0A1)
			return '*';
		if (i < 0xB0C5)
			return 'a';
		if (i < 0xB2C1)
			return 'b';
		if (i < 0xB4EE)
			return 'c';
		if (i < 0xB6EA)
			return 'd';
		if (i < 0xB7A2)
			return 'e';
		if (i < 0xB8C1)
			return 'f';
		if (i < 0xB9FE)
			return 'g';
		if (i < 0xBBF7)
			return 'h';
		if (i < 0xBFA6)
			return 'j';
		if (i < 0xC0AC)
			return 'k';
		if (i < 0xC2E8)
			return 'l';
		if (i < 0xC4C3)
			return 'm';
		if (i < 0xC5B6)
			return 'n';
		if (i < 0xC5BE)
			return 'o';
		if (i < 0xC6DA)
			return 'p';
		if (i < 0xC8BB)
			return 'q';
		if (i < 0xC8F6)
			return 'r';
		if (i < 0xCBFA)
			return 's';
		if (i < 0xCDDA)
			return 't';
		if (i < 0xCEF4)
			return 'w';
		if (i < 0xD1B9)
			return 'x';
		if (i < 0xD4D1)
			return 'y';
		if (i < 0xD7FA)
			return 'z';
		return '*';
	}

}
