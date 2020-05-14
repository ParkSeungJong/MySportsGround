package com.sist.mypage.dao;

import java.util.List;
import java.util.Scanner;

import com.sist.mypage.dao.BookingListDao;
import com.sist.mypage.dao.BookingListVO;

public class BookingHistoryDaoMain {

	public static void main(String[] args) {
		BookingHistoryDao dao = new BookingHistoryDao();

		String input01 = "";
		Scanner scanner = new Scanner(System.in);
		Scanner dataScanner = null;
		do {
			System.out.println("R:조회, Q:종료 >>");
			input01 = scanner.nextLine().toUpperCase();
			if (!input01.equalsIgnoreCase("R")) {
				System.out.println("Command를 다시 입력하세요.");
				continue;
			}

			switch (input01) {

			case "R":
				// public List<DTO> do_retrieve(DTO dto){}
				BookingHistoryVO retrieveVO = dao.getSearchData(dataScanner);
				List<BookingHistoryVO> list = (List<BookingHistoryVO>) dao.do_retrieve(retrieveVO);
				// 출력
				dao.disp(list);
				System.out.println("조회");
				break;

			case "Q":
				System.out.println("종료");
				break;

			default:
				System.out.println("Command를 확인하세요.");
				System.out.println("R:조회, Q:종료 >>");
				break;
			}
		} while (!input01.equalsIgnoreCase("Q"));
		System.out.println("프로그램이 종료 되었습니다.");

	}

}
