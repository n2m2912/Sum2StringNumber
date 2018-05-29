package sn.sumnumber;

public class MyBigNumber {
	public String sum(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		StringBuilder str1 = new StringBuilder(s1).reverse();
		StringBuilder str2 = new StringBuilder(s2).reverse();
		char[] chr1,chr2;
		int n1, n2;
		if (len1 > len2) {
			n1 = len1;
			n2 = len2;
			chr1 = str1.toString().toCharArray();
			chr2 = str2.toString().toCharArray();
		} else {
			n1 = len2;
			n2 = len1;
			chr1 = str2.toString().toCharArray();
			chr2 = str1.toString().toCharArray();
		}
		int tmp = 0, num1, num2 = 0, i = 0;
		int sumTmp;
		String str;
		String sumStr="";
		while (i < n1) {
			char[] chr3;
			num1 = (int) chr1[i] - '0';
			if (i < n2) {
				num2 = (int) chr2[i] - '0';
				sumTmp = num1 + num2 + tmp;
			} else {
				sumTmp=num1+tmp;
			}
			str = sumTmp + "";
			chr3 = str.toCharArray();
			if (chr3.length == 2) {
				sumStr += chr3[1] + "";
				tmp = chr3[0] - '0';
			}else {
				sumStr += chr3[0] + "";
				tmp = 0;
			}
			i++;
		}
		StringBuilder reStr = new StringBuilder(sumStr).reverse();
		return reStr.toString();
	}
}
