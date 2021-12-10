package com.sist.movie;
//영화 시스템 => 메소드
// 1. 데이터를 수집 => 공통으로 사용 (static)

import java.util.*;
import java.io.*;
public class MovieSystem {
//1. 공유할 데이터 선
	private static MovieVO[] movie_data = new MovieVO[1938];
	//사용자 정의 클래스 => 일반 데이터형과 동일하게 사용한다.
	//class => 데이터를 모아서 관
	//클래스 배열, String[] => 객체배열
	//movie_data => 값을 첨부
	static {
		//초기화블록
		try {
			FileReader fr = new FileReader("/Users/namjiwon/Downloads/쌍용자료모음/movie.txt");
			StringBuffer sb = new StringBuffer();
			String totalFile ="";
			int i = 0;
			while((i=fr.read())!=-1) {
				sb.append(String.valueOf((char)i));
			}
			//System.out.println(sb.toString());
			String movie = sb.toString();
			String[]m = movie.split("\n");
			for (int j = 0; j < m.length; j++) {
				String[]rm = m[j].split("\\|");
				MovieVO vo = new MovieVO();
				vo.setNo(Integer.parseInt(rm[0]));
				//Integer.parseInt => Wrapper (각 데이터형별로 클래스가 만들어져있다)
				vo.setTitle(rm[1]);
				vo.setGenre(rm[2]);
				vo.setPoster(rm[3]);
				vo.setActor(rm[4]);
				vo.setRegdate(rm[5]);
				vo.setGrade(rm[6]);
				vo.setDirector(rm[7]);
				//System.out.println("제목:");
				movie_data[j]=vo;
			}
		}catch(Exception ex) {}
	}
	
	public void titleFind(String title) {
		for(MovieVO vo: movie_data) {
			if(vo.getTitle().contains(title)) {
				System.out.println(vo.getTitle());
			}
		}
	}
	
	public void actorFind(String name) {
		for(MovieVO vo: movie_data) {
			if(vo.getActor().contains(name)) {
				System.out.println(vo.getTitle() + "("+vo.getActor()+")");
			}
		}
	}
	
	public void genreFind(String genre) {
		for(MovieVO vo: movie_data) {
			if(vo.getGenre().contains(genre)) {
				System.out.println(vo.getTitle() + "("+vo.getGenre()+")");
			}
		}
	}
	
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
//		for(MovieVO vo: MovieSystem.movie_data) {
//			System.out.println("제목: " + vo.getTitle());
//			System.out.println("장르: " + vo.getGenre());
//			System.out.println("============================================");
//		}
		Scanner sc = new Scanner(System.in);
		System.out.print("영화 제목 입력 : ");
		String title = sc.next();
		ms.titleFind(title);
		System.out.print("주인공 이름 입력 : ");
		String actor = sc.next();
		ms.actorFind(actor);
		System.out.print("장르 입력 : ");
		String genre = sc.next();
		ms.genreFind(genre);
	}
}
