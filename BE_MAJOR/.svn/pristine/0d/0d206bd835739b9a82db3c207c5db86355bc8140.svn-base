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

import com.sist.mypage.dao.BookingHistoryVO;
import com.sist.mypage.dao.DTO;
import com.sist.mypage.dao.UserVO;
import com.sist.mypage.dao.WorkDiv;

public class BookingHistoryDao implements WorkDiv {

	private List<BookingHistoryVO> bookinghistory = new ArrayList<BookingHistoryVO>();
	private final String ADD_FILE = "D:\\Java_20191031\\bookinglist.csv";

	public BookingHistoryDao() {
		bookinghistory = readFile(ADD_FILE);
		disp(bookinghistory);
	}

	// List를 콘솔에 출력
	public void disp(List<BookingHistoryVO> bookinghistory) {
		for (BookingHistoryVO vo : bookinghistory) {
			System.out.println(vo);
		}
	}

	/**
	 * 쉼표로 구분된 데이터를 입력 받아 MemberVO 리턴
	 * 
	 * @param dataScanner
	 * @return
	 */
	public BookingHistoryVO getSearchData(Scanner dataScanner) {
		BookingHistoryVO outVO = null;
		dataScanner = new Scanner(System.in);
		System.out.println("검색 데이터 입력(1:code, 2:지역  ex)2,서울  >>");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim(); // 앞뒤 공백 제거

		String[] dataArray = inputData.split(",");
		outVO = new BookingHistoryVO(inputData, inputData, inputData);
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

			for (int i = 0; i < bookinghistory.size(); i++) {
				BookingHistoryVO vo = bookinghistory.get(i);

				StringBuilder sb = new StringBuilder();
				
				sb.append(vo.getFacilityCode() + ",");
				sb.append(vo.getFacilityName() + ",");
				sb.append(vo.getSelectDate() + ",");

				// 마지막 라인에 "\n"제거
				if ((i + 1) != bookinghistory.size()) {
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

	public List<BookingHistoryVO> readFile(String filePath) {
		List<BookingHistoryVO> bookinghistoryData = new ArrayList<BookingHistoryVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				// GBU004,경기도부천시,쌍용경기장,소사로 482,https://www.sist.co.kr/,032-340-0890,100 x 80
				String[] dataArray = line.split(",");
				BookingHistoryVO vo = new BookingHistoryVO(dataArray[0], dataArray[1], dataArray[2]);
				bookinghistoryData.add(vo);
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

		return bookinghistoryData;
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
		List<BookingHistoryVO> list = new ArrayList<BookingHistoryVO>();
		// 경기장 코드 검색
		BookingHistoryVO inVO = (BookingHistoryVO) dto;
		// 경기장 코드 검색 : 검색구분=="1"
		if (inVO.getSearchDiv().equals("1")) {
			for (int i = 0; i < bookinghistory.size(); i++) {
				BookingHistoryVO vsVO = bookinghistory.get(i);
				if (vsVO.getFacilityCode().matches(".*" + inVO.getSearchWord() + ".*")) {
					list.add(vsVO);
				}

			} // --for
		} else if (inVO.getSearchDiv().equals("2")) {// 지역 검색 : 검색구분 =="2"
			for (int i = 0; i < bookinghistory.size(); i++) {
				BookingHistoryVO vsVO = bookinghistory.get(i);
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
