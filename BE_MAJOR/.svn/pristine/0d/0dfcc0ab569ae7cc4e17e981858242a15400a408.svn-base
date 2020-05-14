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

import com.sist.mypage.dao.BookingListVO;
import com.sist.mypage.dao.DTO;
import com.sist.mypage.dao.UserVO;
import com.sist.mypage.dao.WorkDiv;

public class BookingListDao implements WorkDiv {

	public List<BookingListVO> bookinglist = new ArrayList<BookingListVO>();
	public final String ADD_FILE = "csv\\bookinglist.csv";

	public BookingListDao() {
		bookinglist = readFile(ADD_FILE);
		disp(bookinglist);
	}
	
	
	
	
	/////////////////////////////////////////////////////
//	public boolean isBookingListExists(BookingListVO vo) {
//		boolean flag = false;
//
//		for (int i = 0; i < bookinglist.size(); i++) {
//			BookingListVO vsVO = bookinglist.get(i);
//			// 이메일을 비교, 데이터가 있으면 loop종료
//			if (vsVO.getFacilityName().equals(vo.getFacilityName())) {
//				
//			}
//		}
//		return flag;
//	}
//	

	// List를 콘솔에 출력
	public void disp(List<BookingListVO> bookinglist) {
		for (BookingListVO vo : bookinglist) {
			System.out.println(vo);
		}
	}

	/**
	 * 쉼표로 구분된 데이터를 입력 받아 MemberVO 리턴
	 * 
	 * @param dataScanner
	 * @return
	 */
	public BookingListVO getSearchData(Scanner dataScanner) {
		BookingListVO outVO = null;
		dataScanner = new Scanner(System.in);
		System.out.println("검색 데이터 입력(1:facilityCode, 2:faciltyName  ex)2,쌍용축구장 >>");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim(); // 앞뒤 공백 제거

		String[] dataArray = inputData.split(",");
		outVO = new BookingListVO();
		outVO.setSearchDiv(dataArray[0]);
		outVO.setSearchWord(dataArray[1]);
		// System.out.println("입력: "+outVO);
		return outVO;
	}

	// List에 있는 Data를 파일에 기록
	public int saveFile(String path) {
		int cnt = 0;
		FileWriter writer = null;
		BufferedWriter bw = null;
		File file = new File(path);

		try {
			writer = new FileWriter(file);
			bw = new BufferedWriter(writer);

			for (int i = 0; i < bookinglist.size(); i++) {
				BookingListVO vo = bookinglist.get(i);

				StringBuilder sb = new StringBuilder();
				
				sb.append(vo.getFacilityCode() + ",");
				sb.append(vo.getFacilityName() + ",");
				sb.append(vo.getSelectDate() + ",");

				// 마지막 라인에 "\n"제거
				if ((i + 1) != bookinglist.size()) {
					sb.append("\n");
				}
				cnt++;
				bw.write(sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // --for

		return cnt;
	}

	public List<BookingListVO> readFile(String filePath) {
		List<BookingListVO> bookinglist = new ArrayList<BookingListVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				// GBU004,경기도부천시,쌍용경기장,소사로 482,https://www.sist.co.kr/,032-340-0890,100 x 80
				String[] dataArray = line.split(",");
				BookingListVO vo = new BookingListVO();
				bookinglist.add(vo);
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

		return bookinglist;
	}

	@Override
	public int do_save(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO DTO_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> do_retrieve(DTO dto) {
		List<BookingListVO> list = new ArrayList<BookingListVO>();
		// 경기장 코드 검색
		BookingListVO inVO = (BookingListVO) dto;
		// facilityCode 검색 : 검색구분=="1"
		if (inVO.getSearchDiv().equals("1")) {
			for (int i = 0; i < bookinglist.size(); i++) {
				BookingListVO vsVO = bookinglist.get(i);
				if (vsVO.getFacilityCode().matches(".*" + inVO.getSearchWord() + ".*")) {
					list.add(vsVO);
				}

			} // --for
		} else if (inVO.getSearchDiv().equals("2")) {// facilityName 검색 : 검색구분 =="2"
			for (int i = 0; i < bookinglist.size(); i++) {
				BookingListVO vsVO = bookinglist.get(i);
				if (vsVO.getFacilityName().matches(".*" + inVO.getSearchWord() + ".*")) {
					list.add(vsVO);
				}
			} // --for
		}
		return list;
	}

	@Override
	public DTO do_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
