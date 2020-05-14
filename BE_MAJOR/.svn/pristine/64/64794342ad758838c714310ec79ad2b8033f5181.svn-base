package com.sist.booking.dao;

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

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import com.sist.dto.workdiv.DTO;
import com.sist.dto.workdiv.WorkDiv;
import com.sist.booking.dao.BookingVO;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class BookingDAO implements WorkDiv {
	public List<BookingVO> booking = new ArrayList<BookingVO>();
	public String ADD_FILE = "csv/booking.csv";

	public BookingDAO() {
		booking = readFile(ADD_FILE);
		disp(booking);
	}

	public BookingVO do_selectOne2(BookingVO vo) {
		BookingVO outVO = null;
		BookingVO inVO = vo;

		for (int i = 0; i < booking.size(); i++) {
			BookingVO vsVO = booking.get(i);
			if (vsVO.getFacilityCode().equals(inVO.getFacilityCode())) {
				outVO = vsVO;
				break;
			}
		}
		return outVO;
	}

	/**
	 * 
	 * <pre>
	 * 1. 설명 : 데이터 존재 유무 확인,Key는 Email
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * Method Name : isMemberExists
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
	public boolean isMemberExists(BookingVO vo) {
		boolean flag = false;

		for (int i = 0; i < booking.size(); i++) {
			BookingVO vsVO = booking.get(i);
			// 이메일을 비교, 데이터가 있으면 loop종료
			if (vsVO.getFacilityCode().equals(vo.getFacilityCode())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

//List�? 콘솔?�� 출력
	public void disp(List<BookingVO> booking) {
		for (BookingVO vo : booking) {
			System.out.println(vo);
		}
	}

	/**
	 * 쉼표로 구분된 데이터를 입력 받아 BookingVO 리턴
	 * 
	 * @param dataScanner
	 * @return
	 */
	public BookingVO getSearchData(Scanner dataScanner) {
		BookingVO outVO = null;
		dataScanner = new Scanner(System.in);
		System.out.println("검색 데이터 입력(1.지역 2.날짜>>");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim(); // 앞뒤 공백 제거

		String[] dataArray = inputData.split(",");
		outVO = new BookingVO();
		outVO.setFacilityArea(dataArray[0]);
		outVO.setBookingDate(dataArray[1]);
		// System.out.println("입력: "+outVO);
		return outVO;
	}

	public BookingVO getInputCode(Scanner dataScanner) {
		BookingVO outVO = null;
		dataScanner = new Scanner(System.in);

		System.out.println("처리 데이터 입력 ex)>>SEO001");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim();// 앞뒤 공간 삭제

		outVO = new BookingVO();
		outVO.setFacilityCode(inputData);
		System.out.println("입력:" + outVO);
		return outVO;
	}

	public BookingVO getInputfCode(String code) {
		BookingVO outVO = null;
		String inputData = code.trim();// 앞뒤 공간 삭제

		outVO = new BookingVO();
		outVO.setFacilityCode(inputData);
		System.out.println("입력:" + outVO);
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

			for (int i = 0; i < booking.size(); i++) {
				BookingVO vo = booking.get(i);

				StringBuilder sb = new StringBuilder();
				sb.append(vo.getFacilityCode() + ",");
				sb.append(vo.getFacilityArea() + ",");
				sb.append(vo.getFacilityName() + ",");
				sb.append(vo.getFacilityAddress() + ",");
				sb.append(vo.getBookingDate() + ",");
				sb.append(vo.isBookingPossible() + ",");
				sb.append(vo.getImagePath() + ",");
				sb.append(vo.getUserId() + ",");
				sb.append(vo.getUserName() + ",");
				sb.append(vo.getUserPhoneNumber() + ",");
				sb.append(vo.getBookingCode());

				// 마지막 라인에 "\n"제거
				if ((i + 1) != booking.size()) {
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

	/**
	 * addressBook.csv 파일에서 데이터를 읽어 List<MemberVO> 생성
	 * 
	 * @param filePath
	 * @return List
	 */

	public List<BookingVO> readFile(String filePath) {
		List<BookingVO> facilityData = new ArrayList<BookingVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				// SEO001,서울특별시,쌍용종합운동장,송파구 마천동 산 1-5,20191230,false,user1
				String[] dataArray = line.split(",");
				BookingVO vo = new BookingVO(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4],
						Boolean.valueOf(dataArray[5]), dataArray[6], dataArray[7], dataArray[8], dataArray[9],
						dataArray[10]);
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
	// ====================================================================================

	public BookingVO getUpdatepointData(String code, String userid, String name, String cell) {
		BookingVO outVO = null;
		String inputData = null;
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityCode().equals(code)) {
				inputData = code + "," + vo.getFacilityArea() + "," + vo.getFacilityName() + ","
						+ vo.getFacilityAddress() + "," + vo.getBookingDate() + "," + vo.isBookingPossible() + ","
						+ vo.getImagePath() + "," + userid + "," + name + "," + cell + "," + vo.getBookingCode();

			}

			System.out.println(inputData);
		}

		inputData = inputData.trim();// 앞뒤 공간 삭제
		String[] dataArray = inputData.split(",");
		outVO = new BookingVO(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4],
				Boolean.valueOf(dataArray[5]), dataArray[6], dataArray[7], dataArray[8], dataArray[9], dataArray[10]);

		// System.out.println("입력:" + outVO);
		return outVO;
	}

	public String code(String a, String b, boolean c) {
		if (a == "서울특별시" && b == "20191230") {
			if (c == false) {
				return "SEO001";
			} else if (c == true) {
				return "SEO002";
			}
		} else if (a == "서울특별시" && b == "20191231") {
			if (c == false) {
				return "SEO003";
			} else if (c == true) {
				return "SEO004";
			}
		} else if (a == "경기도" && b == "20191230") {
			if (c == false) {
				return "GBU001";
			} else if (c == true) {
				return "GBU002";
			}
		} else if (a == "경기도" && b == "20191231") {
			if (c == false) {
				return "GBU003";
			} else if (c == true) {
				return "GBU004";
			}
		}
		return b;

	}

	// ====================================================================================

	@Override
	public int do_save(DTO dto) {
		int flag = 0;
		BookingVO vo = (BookingVO) dto;

		booking.add(vo);
		int saveCnt = saveFile(ADD_FILE);
		System.out.println(saveCnt + "건 저장 되었습니다.");

		return flag;
	}

	@Override
	public int do_update(DTO dto) {
		int flag = 0;
		BookingVO modVO = (BookingVO) dto;
		if (isMemberExists(modVO)) {
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
		BookingVO delVO = (BookingVO) dto;
		// 반드시 역순으로 찾고 삭제 해야함.
		for (int i = booking.size() - 1; i >= 0; i--) {
			BookingVO vsVO = booking.get(i);
			if (delVO.getFacilityCode().equals(vsVO.getFacilityCode())) {
				booking.remove(i);
				flag++;
			}
		}
		// 파일에 저장
		if (flag != 0)
			saveFile(ADD_FILE);

		return flag;
	}

	@Override
	public DTO do_selectOne(DTO dto) {
		BookingVO outVO = null;
		BookingVO inVO = (BookingVO) dto;

		for (int i = 0; i < booking.size(); i++) {
			BookingVO vsVO = booking.get(i);
			if (vsVO.getFacilityCode().equals(inVO.getFacilityCode())) {
				outVO = vsVO;
				break;
			}
		}

		return outVO;
	}

	@Override
	public List<?> do_retrieve(DTO dto) {
		List<BookingVO> list = new ArrayList<BookingVO>();
		// 지역, 날짜 검색
		BookingVO inVO = (BookingVO) dto;
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vsVO = booking.get(i);
			if (vsVO.getFacilityArea().matches(inVO.getFacilityArea())
					&& vsVO.getBookingDate().matches(inVO.getBookingDate())) {
				list.add(vsVO);
				// System.out.println(vsVO.isBookingPossible());//전체목록중에 예약가능한 목록 출력
			}

		}

		return list;
	}

	public String do_retrievecode(String ab, String bb) {
//		List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				if (vo.isBookingPossible() != false) {
					list += vo.getFacilityCode();
				}
			}
		}
		return list;
	}
	
	public String do_retrieveName1(String ab, String bb) {
//		List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				if (vo.isBookingPossible() == false) {
					list += vo.getFacilityName() + "\t";
				}
			}
		}
		return list;
	}

	public String do_retrieveName2(String ab, String bb) {
//		List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				if (vo.isBookingPossible() != false) {
					list += vo.getFacilityName() + "\t";
				}
			}
		}
		return list;
	}

	public String do_retrieveDate1(String ab, String bb) {
//			List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				if (vo.isBookingPossible() == false) {
					list += vo.getBookingDate() + "\t";
				}
			}
		}
		return list;

	}

	public String do_retrieveDate2(String ab, String bb) {
//			List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				if (vo.isBookingPossible() != false) {
					list += vo.getBookingDate() + "\t";
				}
			}
		}
		return list;

	}

	public String do_retrieveAddress1(String ab, String bb) {
//			List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {

				if (vo.isBookingPossible() == false) {
					list += vo.getFacilityAddress() + "\t";
				}
			}
		}
		return list;

	}

	public String do_retrieveAddress2(String ab, String bb) {
//			List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {

				if (vo.isBookingPossible() != false) {
					list += vo.getFacilityAddress() + "\t";
				}
			}
		}
		return list;

	}

	public String do_retrieveImagePath1(String ab, String bb) {
//			List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {

				if (vo.isBookingPossible() == false) {
					list += vo.getImagePath();
				}
			}
		}
		return list;

	}

	public String do_retrieveImagePath2(String ab, String bb) {
//		List<BookingVO> list = new ArrayList<BookingVO>();

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {

				if (vo.isBookingPossible() != false) {
					list += vo.getImagePath();
				}
			}
		}
		return list;
	}

	public boolean do_retrieveBookBtn1(String ab, String bb) {
//		List<BookingVO> list = new ArrayList<BookingVO>();

		boolean list = false;
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {

				if (vo.isBookingPossible() != false) {
					list = vo.isBookingPossible();
				}
			}
		}
		return list;
	}

	public boolean do_retrieveBookBtn2(String ab, String bb) {
//		List<BookingVO> list = new ArrayList<BookingVO>();

		boolean list = false;
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {

				if (vo.isBookingPossible() == false) {
					list = vo.isBookingPossible();
				}
			}
		}
		return list;
	}

	public Paint do_retrieveColor1(String ab, String bb) {
//			List<BookingVO> list = new ArrayList<BookingVO>();

		Paint list = Color.BLUE;
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				if (vo.isBookingPossible() == false) {

					list = Color.RED;
				}
			}
		}
		return list;

	}

	public Paint do_retrieveColor2(String ab, String bb) {
//		List<BookingVO> list = new ArrayList<BookingVO>();

		Paint list = Color.BLUE;
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				if (vo.isBookingPossible() != false) {

					list = Color.BLUE;
				}
			}
		}
		return list;

	}

	public String do_retrieveArray(String ab, String bb) {//

		String list = "";
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vo = booking.get(i);
			if (vo.getFacilityArea().equals(ab) && vo.getBookingDate().equals(bb)) {
				list += vo.getFacilityCode() + "\t" + vo.getFacilityArea() + "\t" + vo.getFacilityName() + "\t"
						+ vo.getFacilityAddress() + "\t" + vo.getBookingDate() + "\t" + vo.isBookingPossible() + "\n";
			}
		}
		return list;
	}

	// @Override
	public List<?> bookingPossible(DTO dto) {
		List<BookingVO> list = new ArrayList<BookingVO>();

		BookingVO inVO = (BookingVO) dto;
		for (int i = 0; i < booking.size(); i++) {
			BookingVO vsVO = booking.get(i);
			if (vsVO.getFacilityArea().matches(inVO.getFacilityArea())
					&& vsVO.getBookingDate().matches(inVO.getBookingDate())) {
				// list.add(vsVO);

				// System.out.println(vsVO.isBookingPossible());//�??��목록중에?�� ?��?���??��?�� 추출
			}

		}

		return list;
	}

}