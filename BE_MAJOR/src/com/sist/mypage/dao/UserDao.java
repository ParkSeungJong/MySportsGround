/**
 *<pre>
 * com.sist.mypage.dao
 * Class Name : UserDao.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2019-12-11           최초생성
 *
 * @author 개발프레임웍크 실행환경 BE_MAJOR
 * @since 2019-12-11 
 * @version 1.0
 * 
 *
 *  Copyright (C) by BE_MAJOR All right reserved.
 * </pre>
 */
package com.sist.mypage.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sist.mypage.dao.DTO;
import com.sist.mypage.dao.UserVO;

/**
 * <pre>
 * com.sist.mypage.dao
 *    |_ UserDao.java
 * 
 * </pre>
 * 
 * @date : 2019. 12. 11. 오후 4:23:19
 * @version :
 * @author : sist
 */
public class UserDao implements WorkDiv {

	public List<UserVO> userinfo = new ArrayList<UserVO>();
	// private final String ADD_FILE = "src\\com\\sist\\mypage\\dao\\userinfo.csv";
	public String ADD_FILE = "csv\\userinfo.csv";

	public UserDao() {
		userinfo = readFile(ADD_FILE);
		disp(userinfo);
	}

	/**
	 * 
	 * <pre>
	 * 1. 설명 : 데이터 존재 유무 확인,Key는 Id
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : isUserExists
	 * 
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 4. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param vo
	 * @return boolean
	 */
	public boolean isUserExists(UserVO vo) {
		boolean flag = false;

		for (int i = 0; i < userinfo.size(); i++) {
			UserVO vsVO = userinfo.get(i);
			// 아이디를 비교, 데이터가 있으면 loop종료
			if (vsVO.getId().equals(vo.getId())) {

			}
		}
		return flag;
	}

	/**
	 * 
	 * <pre>
	 * 1. 설명 : 쉼표로 구분된 데이터를 입력 받아 UserVO 돌려 준다.
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : getInputData
	 * 
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 4. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param dataScanner
	 * @return UserVO
	 */
	public UserVO getSearchData(Scanner dataScanner) {
		UserVO outVO = null;
		dataScanner = new Scanner(System.in);
		System.out.println("검색 데이터 입력(1:id, 2:pw  ex)2,1235  >>");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim();// 앞뒤 공간 삭제

		String[] dataArray = inputData.split(",");
		outVO = new UserVO(inputData, inputData, inputData, inputData, inputData, inputData);
		outVO.setSearchDiv(dataArray[0]);
		outVO.setSearchWord(dataArray[1]);

		// System.out.println("입력:" + outVO);
		return outVO;
	}

	/**
	 * 
	 * <pre>
	 * 1. 설명 : 쉼표로 구분된 데이터를 입력 받아 UserVO 돌려 준다.
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : getInputData
	 * 
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 4. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param dataScanner
	 * @return UserVO
	 */
	public UserVO getInputEmail(Scanner dataScanner) {
		UserVO outVO = null;
		dataScanner = new Scanner(System.in);
		System.out.println("처리 데이터 입력 ex)admin1>>");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim();// 앞뒤 공간 삭제
		outVO = new UserVO(inputData, inputData, inputData, inputData, inputData, inputData);
		outVO.setId(inputData);
		System.out.println("입력:" + outVO);
		return outVO;
	}

	/**
	 * 
	 * <pre>
	 * 1. 설명 : 쉼표로 구분된 데이터를 입력 받아 UserVO 돌려 준다.
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : getInputData
	 * 
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 4. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param dataScanner
	 * @return UserVO
	 */
	public UserVO getInputData(Scanner dataScanner) {
		UserVO outVO = null;
		dataScanner = new Scanner(System.in);
		System.out.println("처리 데이터 입력 ex)admin1,1235,이쌍용,서울시 강남구,kimssang@naver.com,010-1111-0004>>");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim();// 앞뒤 공간 삭제

		String[] dataArray = inputData.split(",");
		outVO = new UserVO(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
		System.out.println("입력:" + outVO);
		return outVO;
	}

	// List에 있는 Data를 파일에 기록
	/**
	 * 
	 * <pre>
	 * 1. 설명 : 파일을 저장한다.
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : saveFile
	 * 
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 4. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param dataScanner
	 * @return
	 */
	public int saveFile(String path) {
		int cnt = 0;
		FileWriter writer = null;
		BufferedWriter bw = null;
		File file = new File(path);

		try {
			writer = new FileWriter(file);
			bw = new BufferedWriter(writer);

			// --------------------------------------
			for (int i = 0; i < userinfo.size(); i++) {
				UserVO vo = userinfo.get(i);

				StringBuilder sb = new StringBuilder();
				sb.append(vo.getId() + ",");
				sb.append(vo.getPw() + ",");
				sb.append(vo.getUserName() + ",");
				sb.append(vo.getUserAddress());
				sb.append(vo.getUserEmail());
				sb.append(vo.getUserPhone());

				// 마지막 라인에 "\n" 제거
				if ((i + 1) != userinfo.size()) {
					sb.append("\n");
				}

				cnt++;
				bw.write(sb.toString());

			}
			// --------------------------------------
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != bw) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	
	/**
	 * <pre>
	 * 1. 설명 : List를 console에 출력
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : readFile
	 * 
	 * @since : 2019. 12. 3.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 3. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param userinfo
	 * @return List
	 */
	// List를 콘솔에 출력
	public void disp(List<UserVO> userinfo) {
		for (UserVO vo : userinfo) {
			System.out.println(vo);
		}
	}

	/**
	 * <pre>
	 * 1. 설명 : userinfo.csv파일에서 데이터를 읽어 List<UserVo> 생성
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : readFile
	 * 
	 * @since : 2019. 12. 3.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 3. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @param filePath
	 * @return List
	 */

	public List<UserVO> readFile(String filePath) {
		List<UserVO> UserData = new ArrayList<UserVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {

//				user1,1234,홍길동,서울시마포구,honggildong@naver.com,010-1111-0001
//				user2,1234,김길동,서울시관악구,kimgildong@naver.com,010-1111-0002
//				user3,1234,이길동,서울시영등포구,leegildong@naver.com,010-1111-0003
//				admin1,1235,김쌍용,서울시강남구,kimssang@naver.com,010-1111-0004

				String[] dataArray = line.split(",");
				UserVO vo = new UserVO(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4],
						dataArray[5]);
				UserData.add(vo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return UserData;
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : do_save
	 * 
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history :
	 *          -----------------------------------------------------------------------
	 *          변경일 작성자 변경내용 ----------- -------------------
	 *          --------------------------------------- 2019. 12. 4. sist 최초 작성
	 *          -----------------------------------------------------------------------
	 * 
	 * @see com.sist.dto.workdiv#do_save(com.sist.dto)
	 * @param dto
	 * @return
	 */
	@Override
	public int do_save(DTO dto) {
		int flag = 0;
		UserVO vo = (UserVO) dto;

		userinfo.add(vo);
		int saveCnt = saveFile(ADD_FILE);
		System.out.println(saveCnt + "건 저장 되었습니다.");

		return flag;
	}

	@Override
	public int do_update(DTO dto) {
		int flag = 0;
		UserVO modVO = (UserVO) dto;
		if (isUserExists(modVO) == true) {
			flag = do_delete(modVO);
			if (flag > 0) {
				do_save(modVO);
			}

		}
		return flag;
	}

	@Override
	public int do_delete(DTO dto) {
		int flag = 0;
		UserVO delVO = (UserVO) dto;
		// 반드시 역순으로 찾고 삭제 해야함.
		for (int i = userinfo.size() - 1; i >= 0; i--) {
			UserVO vsVO = userinfo.get(i);
			if (delVO.getId().equals(vsVO.getId())) {
				userinfo.remove(i);
				flag++;
			}
		}

		// 파일에 저장
		if (flag != 0)
			saveFile(ADD_FILE);

		return flag;
	}

//	@Override
//	public UserVO DTO_selectOne(DTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<?> do_retrieve(DTO dto) {
		List<UserVO> list = new ArrayList<UserVO>();
		// Id검색
		UserVO inVO = (UserVO) dto;
		// Id검색 :검색 구분이=="1"
		if (inVO.getSearchDiv().equals("1")) {

			for (int i = 0; i < userinfo.size(); i++) {
				UserVO vsVO = userinfo.get(i);
				// %james%
				if (vsVO.getId().matches(".*" + inVO.getSearchWord() + ".*")) {
					list.add(vsVO);
				}
			}

		} else if (inVO.getSearchDiv().equals("2")) { // Pw : 검색구분이 == "2"
			for (int i = 0; i < userinfo.size(); i++) {
				UserVO vsVO = userinfo.get(i);
				if (vsVO.getPw().matches(".*" + inVO.getSearchWord() + ".*")) {
					list.add(vsVO);
				}
			}
		}

		return list;
	}

	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * Method Name : do_selectOne
	 * @since : 2019. 12. 4.
	 * @author : sist
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 12. 4.		sist				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.sist.dto.workdiv#do_save(com.sist.dto)
	 * @param dto
	 * @return
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		UserVO outVO = null;
		UserVO inVO = (UserVO) dto;

		for (int i = 0; i < userinfo.size(); i++) {
			UserVO vsVO = userinfo.get(i);
			if (vsVO.getId().equals(inVO.getId())) {
				outVO = vsVO;
				break;
			}
		}

		return outVO;
	}

	@Override
	public UserVO DTO_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserVO> do_read(String ADD_FILE) {
		this.ADD_FILE = ADD_FILE;
		ArrayList<UserVO> facilityData = new ArrayList<UserVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(ADD_FILE);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] dataArray = line.split(",");
				UserVO vo = new UserVO(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4],
						dataArray[5]);
				facilityData.add(vo);
			} // --while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // --if
		}

		return facilityData;
	}

}
