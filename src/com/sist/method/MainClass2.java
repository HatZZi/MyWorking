package com.sist.method;

import java.util.*;

public class MainClass2 {
	
	public static void main(String[] args) {
		int []com = {5,8,3};
		int []user = new int[3];
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("세자리 정수를 입력하세요!! : ");
			int input = sc.nextInt();
			if(input>99 && input<1000) {
				
			}
			if(input<100 || input>999){
				System.out.println("세자리 정수만 사용해야된답니다!!");
				continue;  // while=>while의 조건문 이동, for=>증가식으로 이동
			}
			user[0] = input/100;
			user[1] = (input%100)/10;
			user[2] = input%10;
			
			if(user[0]==user[1] || user[1]==user[2] || user[2]==user[0]) {
				System.out.println("중복된 숫자는 사용할 수 없습니다!!");
				continue;
			}
			if(user[0]==0 || user[1]==0 || user[2]==0) {
				System.out.println("0을 사용할 수 없습니다!!");
				continue;
			}
			int s = 0;
			int b = 0;
			for (int i = 0; i < 3; i++) {  //com
				for (int j = 0; j < 3; j++) {  //user
					if(com[i]==user[j]) {  //같은수가 있는지 여부
						if(i==j) {
							s++;   //같은 자리 수 라면
						}else {
							b++;  //다른 자리라면
						}
					}
				}
			}
			System.out.printf("Input Numer : %d, Result : %dS=%dB\n", input, s, b);
			if(s==3) {
				System.out.println("GameOver!!!!");
				break;
			}
		}
	}

}
