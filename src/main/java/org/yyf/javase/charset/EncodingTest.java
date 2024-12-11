package org.yyf.javase.charset;

import java.io.UnsupportedEncodingException;

public class EncodingTest {
	//https://openatomworkshop.csdn.net/673ffcd382931a478c227d10.html?dp_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6NjIyMjM1NSwiZXhwIjoxNzMyNTE0MTk5LCJpYXQiOjE3MzE5MDkzOTksInVzZXJuYW1lIjoibGF6eWd1eTIxIn0.4BXpjjiEsv1pol5pJ0UnMr7bJqloqVZqUGXyVtkBNJg&spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Eactivity-3-52853214-blog-131686342.235%5Ev43%5Epc_blog_bottom_relevance_base9&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Eactivity-3-52853214-blog-131686342.235%5Ev43%5Epc_blog_bottom_relevance_base9&utm_relevant_index=5

	public static void main(String[] args) throws UnsupportedEncodingException {
		String srcString = "我们是中国人";
		byte[] GbkBytes = srcString.getBytes("GBK");
		System.out.println("GbkBytes.length:" + GbkBytes.length);
		byte[] UtfBytes = srcString.getBytes("UTF-8");
		System.out.println("UtfBytes.length:" + UtfBytes.length);
		String s;
		for (int i = 0; i < srcString.length(); i++) {
			s = Character.valueOf(srcString.charAt(i)).toString();
			System.out.println(s + ":" + s.getBytes().length);
		}
	}
}