package com.sist.facility.dao;


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


import com.sist.dto.workdiv.DTO;
import com.sist.facility.dao.FacilityVO;
import com.sist.dto.workdiv.WorkDiv;

public class FacilityDAO implements WorkDiv {
	private List<FacilityVO> facilityinfo = new ArrayList<FacilityVO>();
	private final String ADD_FILE = "csv/facilityinfo.csv";


	public FacilityDAO() {
		facilityinfo = readFile(ADD_FILE);
		disp(facilityinfo);
	}


	//List를 콘솔에 출력
	public void disp(List<FacilityVO> facilityinfo) {
		for(FacilityVO vo :facilityinfo ) {
			System.out.println(vo);
		}
	}

	public List<FacilityVO> do_read(String filePath){
		ArrayList<FacilityVO> facilityData = new ArrayList<FacilityVO>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine())!=null) {
				String[] dataArray = line.split(",");
				FacilityVO vo =new FacilityVO(dataArray[0],dataArray[1]);
				facilityData.add(vo);
			}//--while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br!= null) {
				try {
					br.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}//--if
		}
		
		return facilityData;		
	}
	
	public FacilityVO getSearchData(Scanner dataScanner){
		FacilityVO outVO =null;
		dataScanner = new Scanner(System.in);
		System.out.println("검색 데이터 입력(1:code, 2:지역  ex)2,서울  >>");
		String inputData = dataScanner.nextLine();
		inputData = inputData.trim(); //앞뒤 공백 제거

		String[] dataArray = inputData.split(",");
		outVO = new FacilityVO();
		outVO.setSearchDiv(dataArray[0]);
		outVO.setSearchWord(dataArray[1]);
		//System.out.println("입력: "+outVO);
		return outVO;
	}


	//List에 있는 Data를 파일에 기록
	public int saveFile(String path) {
		int cnt =0;
		FileWriter writer = null;
		BufferedWriter bw = null;
		File file  = new File(path);

		try {
			writer = new FileWriter(file);
			bw = new BufferedWriter(writer);

			for(int i=0;i<facilityinfo.size();i++) {
				FacilityVO vo =facilityinfo.get(i);

				StringBuilder sb =new StringBuilder();
				sb.append(vo.getFacilityCode()+",");
				sb.append(vo.getFacilityArea()+",");
				sb.append(vo.getFacilityName()+",");
				sb.append(vo.getFacilityAddress()+",");
				sb.append(vo.getFacilitySite()+",");
				sb.append(vo.getFacilityPhone()+",");
				sb.append(vo.getFacilitySize());
				//마지막 라인에 "\n"제거
				if((i+1)!=facilityinfo.size()) {
					sb.append("\n");
				}
				cnt++;
				bw.write(sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!= null) {
					bw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}		
		}//--for

		return cnt;
	}

	/**
	 * addressBook.csv 파일에서 데이터를 읽어 List<MemberVO> 생성
	 * @param filePath
	 * @return List
	 */
	
	public List<FacilityVO> readFile(String filePath){
	      List<FacilityVO> facilityList = new ArrayList<FacilityVO>();
	      BufferedReader br = null;
	      try {
	         FileReader fr = new FileReader(filePath);
	         br = new BufferedReader(fr);
	         String line = "";
	         while((line = br.readLine())!=null) {
	            String[] dataArray = line.split(",");
	            FacilityVO vo =new FacilityVO(  dataArray[0],dataArray[1],
												dataArray[2],dataArray[3],
												dataArray[4],dataArray[5],
												dataArray[6],dataArray[7],
												dataArray[8],dataArray[9],
												dataArray[10],dataArray[11],
												dataArray[12]
												);
	            facilityList.add(vo);
	         }//--while
	         
	         
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         if(br!= null) {
	            try {
	               br.close();
	            }catch(IOException e) {
	               e.printStackTrace();
	            }
	         }//--if
	      }
	      
	      return facilityList;
	   }


	@Override
	public int do_save(DTO dto) {
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
	public DTO do_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> do_retrieve(DTO dto) {
		List<FacilityVO> list = new ArrayList<FacilityVO> ();
		//경기장 코드 검색
		FacilityVO inVO = (FacilityVO)dto;
		//경기장 코드 검색 : 검색구분=="1"
		if(inVO.getSearchDiv().equals("1")) {
			for(int i=0;i<facilityinfo.size();i++) {
				FacilityVO vsVO = facilityinfo.get(i);
				if(vsVO.getFacilityCode().matches(".*"+inVO.getSearchWord()+".*")) {
					list.add(vsVO);
				}

			}//--for
		}else if(inVO.getSearchDiv().equals("2")) {//지역 검색 : 검색구분 =="2"
			for(int i=0;i<facilityinfo.size();i++) {
				FacilityVO vsVO = facilityinfo.get(i);
				if(vsVO.getFacilityArea().matches(".*"+inVO.getSearchWord()+".*")) {
					list.add(vsVO);
				}
			}//--for
		}
		return list;
	}
}