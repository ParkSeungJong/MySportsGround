/**
 *<pre>
 * com.sist.hr.addressbook
 * Class Name : AddressBookDaoMain.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2019-12-04           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2019-12-04 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.sist.mypage.dao;

import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 * com.sist.hr.addressbook 
 *    |_ AddressBookDaoMain.java
 * 
 * </pre>
 * 
 * @since : 2019. 12. 4. 오후 2:41:00
 * @version :
 * @author : sist
 */
public class UserDaoMain {

	/**
	 * <pre>
	 * 1. 설명 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : main
	 * 
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 4. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao dao = new UserDao();

		String input01 = "";
		Scanner scanner = new Scanner(System.in);
		Scanner dataScanner = null;
		do {

			System.out.println("C:등록,R:조회,U:수정,D:삭제,Q,:종료,SR:단건조회>>");
			input01 = scanner.nextLine().toUpperCase();
			if (!input01.equalsIgnoreCase("C") && !input01.equalsIgnoreCase("R") && !input01.equalsIgnoreCase("U")
					&& !input01.equalsIgnoreCase("D") && !input01.equalsIgnoreCase("Q")
					&& !input01.equalsIgnoreCase("SR")) {
				System.out.println("Command를 다시 입력 하세요.");
				continue;
			}

			switch (input01) {
			case "SR":// 단건조회
				UserVO sOneVO = dao.getInputEmail(dataScanner);
				UserVO resultVO = (UserVO) dao.do_selectOne(sOneVO);
				System.out.println("=========================");
				System.out.println("resultVO=" + resultVO);
				System.out.println("=========================");
				break;
			case "C":
				// data입력
				UserVO vo = dao.getInputData(dataScanner);
				if (dao.isUserExists(vo) == true) {
					System.out.println("존재하는 mail입니다.");
					continue;
				}
				dao.do_save(vo);
				break;
			case "U":
				// 삭제+추가
				// 1.입력
				// 2.데이터가 있는지 확인:method
				// public boolean isMemberExists(MemberVO vo){}
				// 2.1.삭제
				// 2.2.추가
				// 2.3.파일에 기록
				UserVO modVO = dao.getInputData(dataScanner);
				dao.do_update(modVO);

				System.out.println("수정");
				break;
			case "R":
				//public List<DTO> do_retrieve(DTO dto){}
				UserVO retrieveVO = dao.getSearchData(dataScanner);
				List<UserVO> list = (List<UserVO>) dao.do_retrieve(retrieveVO);
				// 출력
				dao.disp(list);

				System.out.println("조회");
				break;

			case "D":
				// public int do_delete(MemberVO delVO){}
				// param read
				UserVO delVO = dao.getInputEmail(dataScanner);
				int flag = dao.do_delete(delVO);

				System.out.println(flag + "건 삭제 되었습니다.");
				break;
			case "Q":
				System.out.println("종료");
				break;
			default:
				System.out.println("Command를 확인하세요.");
				System.out.println("C:등록,R:조회,U:수정,D:삭제,Q:종료>>");
				break;
			}

		} while (!input01.equalsIgnoreCase("Q"));
		System.out.println("프로그램 종료 되었습니다.");

	}

}
