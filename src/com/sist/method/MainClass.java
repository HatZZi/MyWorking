package com.sist.method;
//자바구조
//package =>1번만 사용이 가능
//import =>라이브러리읽기(여러번 가능)
//public class ClassName
//{
// =======================
//      멤버변수 =>클래스에서 사용되는 변수( 9:1 )
//       = 인스턴스 변수 (개별변수) => new사용시마다 따로 저장
//       = 정적변수(static) =>범위(공유변수)
//       예) 사람이름 => 인스턴스
//           학교명 => static
//       =>생성시기
//         인스턴스 => new , delete (자바 => 가비지컬렉션으로 자동회수)
//         static => 클래스가 JVM에서 로딩(읽어 온 경우에)
//       접근 범위
//       ==============================================================
//           자신의 클래스 | 같은 패키지에 있는 클래스 | 상속이 있는 경우 | 모든 클래스
//       ==============================================================
//   private   O   
//       ==============================================================
//   default   O                 O
//       ==============================================================
//   protected O                 O                    O
//       ==============================================================
//   public    O                 O                    O             O
//
//       private : 은닉화 (다른 클래스에서 접근 금지) => 캡슐화
//                 => 변수
//       public : 공개 (모든곳에서 사용이 가능) => 
//                 => 메소드, 클래스, 생성자
//       소스 코딩 => 캡슐화(getter setter)
//                  변수 => 기능(읽기 쓰기)
// ==================================================활용
//    검색, 저장, 수정, 삭제 =>기능을 만드는것(메소드) =>필요시마다 재사용
//    =>기능을 새롭게 추가 : 오버로딩 (메소드 추가)
//    => 기존의 기능 변경 : 오버라이딩(메소드 재정의)
//
//         메소드 제작 (변수 / 연산자 / 제어문)
//         1. 구성요소
//            메소드 : 선언부 / 구현부
//                   =====
//                   리턴형 => 사용자요청시에 요청처리에 대한 결과값을 리턴
//                        => 단 한개만 리턴. 여러개일땐 묶어서 전송(배열,클래스)
//                   매개변수=> 요청자가 요청한 값
//                        웹 => 사용자가 입력 => 메소드의 매개변수로 들어온다.
//         2. 메소드 형식
//            접근지정어(public) 리턴형(결과값) 메소드명( 매개변수...) 선언
//                            =>결과값이 없는 경우(void)
//                            =>처리가 메소드 안에서 된다.
//            메소드는 {}구현 => 메모리 저장이 가능하다.
//            메소드가 선언만 되어있으면 => 메모리에 저장 불가능
//                                   미완성된 클래스(추상, 인터페이스)
//
//             =================================
//                리턴형                매개변수
//             =================================
//                  O                    O
//             =================================
//                  O SELECT             X
//             =================================
//                  X void               O
//             =================================
//                  X void               X=>극히 드물다.
//             =================================
//               네트워크(게임, 실시간채팅) => 쓰레드
//               데이터베이스 (웹) => 메소드 이용
//         ===================================================
//            1. 멤버변수 => 초기값
//               =명시적인 초기화 String id = "admin"
//               =외부에서 데이터 읽기(파일, 오라클) =>class영역에서는 사용이 불가능.
//                                             구현 => {}  생성자 => 멤버변수 초기화
//                                                             => 리턴형이 없다.
//                                                             => 오버로딩을 지원.
//                                                             => 서버연결 / 오라클 드라이버 설
//               =초기화 블록
//                class A {
//                   선언
//                  {
//                    구현 => 인스턴스 블록
//                   }
//         ===================================================
//         함수  VS  메소드
//         ===================================================
//       
//         ===================================================
//       
//         ===================================================
//       
//         ===================================================
// ==================================================
//
// ==================================================
import java.util.*;

class MyDate{
	//데이터 변질 => 은닉화 (MyDate에서 사용하는 변수
	private int year, month, week;
	private int[]lastday = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public int input(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + "입력 :");
		return sc.nextInt();
	}
	
	public int getWeek() {
		int week = 0;
		int total = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		if(year%4 ==0 && year%100 !=0 || year%400==0) {
			lastday[1] = 29;
		}else {
			lastday[1] = 28;
		}
		for (int i = 0; i < month-1; i++) {
			total += lastday[i];
		}
		total++;
		week = total%7;
	
		
		return week;
	}
	
	public void datePrint() {
		String[]strWeek = {"일", "월", "화", "수", "목", "금", "토"};
		for(String s: strWeek) {
			System.out.print(s+"\t");
		}
		System.out.println();
		for (int i = 1; i <= lastday[month-1]; i++) {
			if(i==1) {
				for (int j = 0; j < week; j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6) {
				week=0;
				System.out.println();
			}
		}
	}
	
	public void process() {
		year = input("년도");
		month = input("월");
		week = getWeek();
		datePrint();
		System.out.println(year + "년도" + month + "월");
	}
}

public class MainClassCalander {
	
	public static void main(String[] args) {
		//1.메모리 할당
		MyDate md = new MyDate();
		md.process();
	}

}