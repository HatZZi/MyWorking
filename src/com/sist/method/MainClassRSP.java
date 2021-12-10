package com.sist.method;

import java.util.Scanner;

//     제어문
//    ======= 형식
//    조건문 : 단일조건문(if), 선택조건문(if~else)
//           형식 : if(조건문true/false) { 조건이 true일때 수행}
//    반복문 : for, while (데이터베이스, 네트워크)
//           ====for-each
//           for(데이터형 변수:배열(컬랙션)) => 형변환
//               ======저장된 데이터보다 크면 상관없다.
//           {   배열이나 컬렉션에 저장된 데이터를 대입   }
//           for
//           ===> 일반 for
//           for(초기값; 조건식; 증감식){   실행문장   }
//
//           while : 무한루프  : 반드시 종료조건을 처리!!
//           while(조건문) {  반복실행문장   증감식  }
//    반복제어문 : break 반복을 중단

public class MainClassRSP {
	
	public static void main(String[] args) {
		String[]result = {"가위", "바위", "보"};
		//컴퓨터가 가위 바위 보 =>선택
		int com = (int)(Math.random()*3);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(0) 바위(1) 보(2) 입력:");
		int user = sc.nextInt();
		System.out.println("============결과===============");
		System.out.println( "컴퓨터:"+result[com]);
		System.out.println("사용자:" +result[user]);
		
		int r = com-user;
		if(r==-1 || r==2) {
			System.out.println("사용자 WIN!!!");
		}else if(r==-2 || r==1) {
			System.out.println("컴퓨터 WIN!!!");
		}else {
			System.out.println("비겼다!!!");
		}
		
	}
}
