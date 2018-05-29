package sn.main;

import java.util.Scanner;

import sn.sumnumber.MyBigNumber;

public class SNMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi so s1: ");
		String s1=sc.nextLine();
		System.out.print("Nhap chuoi so s2: ");
		String s2=sc.nextLine();
		MyBigNumber mbn = new MyBigNumber();
		System.out.println("Tong cua chuoi "+s1+" va "+s2+" la "+mbn.sum(s1, s2));
		
	}

}
