package com.sist.mypage.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sist.booking.dao.BookingDAO;
import com.sist.booking.dao.BookingVO;
import com.sist.dto.workdiv.BE_Major;
import com.sist.hr.member.domain.MemberVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class MyPage02_BookingListController implements Initializable {

	@FXML TextField facilityName;
	@FXML TextField selectDate;
	@FXML TextField facilityName2;
	@FXML TextField selectDate2;
	
	
	@FXML Button bookinglistbtn;
	@FXML Button userinfobtn;
	@FXML Button bookinghistorybtn;
	
	@FXML ImageView imageView;
	@FXML ImageView imageView2;
	@FXML ImageView Logo;
	
	
	public static List<BookingVO> bookinglist;
	public static final String FILE_PATH  = "csv/booking.csv";
	
	
	public static String userId;		//회원 아이디
	public static String userPw;		//회원 비밀번호
	public static String userNm;		//회원 이름
	public static String userMail;		//회원 이메일
	public static String userAdd;		//회원 주소
	public static String userCellphone;	//회원 번호
	public static String userAuth;		//회원모드(이용자,관리
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//로고 이미지 클릭시 메인페이지로 이동	
		Logo.setOnMouseClicked(event -> MoveToMainPg(event));
		
		
		
		
		 
		BookingDAO bookingdao = new BookingDAO();
		BookingVO bookingvo= new BookingVO();
		bookinglist = new ArrayList<BookingVO>();
		bookinglist = readFile(FILE_PATH);
	
		System.out.println("BE_Major:"+BE_Major.vo);
		
	 	for (int i = 0; i < bookingdao.booking.size(); i++) {
			BookingVO vsVO = bookingdao.booking.get(i);
			// 아이디비교
			if (vsVO.getUserId().equals(BE_Major.vo.getMemId())) {
				facilityName.setText(vsVO.getFacilityName());
				facilityName2.setText(vsVO.getFacilityName());
				selectDate.setText(vsVO.getBookingDate());
				selectDate2.setText(vsVO.getBookingDate());

			}
		}
		
		
		
//		if(outVO.getMessageDiv().equals("11")) {
//			userId 		    = outVO.getMemId();
//			userPw			= outVO.getPw();
//			userNm			= outVO.getName();
//			userMail		= outVO.getEmail();
//			userAdd			= outVO.getAddress();
//			userCellphone	= outVO.getCellphone();
//			userAuth		= outVO.getAuth();
//		}
			
		
		

	 	
	 	
	 	//userId 		    = outVO.getMemId();
		
	 	
		//String bookingFsName = Booking02_listController.bookingFsName;
	 	
	
		//bookingFsName=bookingdao.do_retrieveName2(bookingFsName, bookingFsName);
		//facilityName.setText(bookingFsName);
		
		
		
		
		
		
		
		
//		//경기장이름
//	     String a01 =bookinglist.get(0).getFacilityName();
//	     facilityName.setText(a01);
//	     
//	     String a02 =bookinglist.get(1).getFacilityName();
//	     facilityName2.setText(a02);
//		
//		
//	
//	     
//	     
//	     //경기장 이미지
//	     
////	     URL url = getClass().getResource("/img/SEO001_1.PNG");
////	     System.out.println(url);
////	     String a05= bookinglist.get(0).getImagePath();
////	     
//
//	     Image image = new Image(getClass().getResourceAsStream("/img/SEO001_1.PNG")); 
//	     imageView.setImage(image);
//	     Image image2 = new Image(getClass().getResourceAsStream("/img/SEO002_1.jpg")); 
//	     imageView2.setImage(image2);
//	     
////	     Image image = new Image(getClass().getResource("/img/SEO001_1.PNG").toString());
////	     System.out.println(image);
////	     imageView.setImage(image);

		
	

		
	}


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
	
	
	//상단 로고 클릭시 메인페이지로 이동
	 	public void MoveToMainPg(MouseEvent event) {
	 		try {

	 			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mainpage/view/MainPage.fxml"));
	 			Scene scene = new Scene(root);
	 			Stage primaryStage = (Stage) Logo.getScene().getWindow();
	 			primaryStage.setScene(scene);
	 			primaryStage.show();

	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 	}
	   
	
	
			

	public void saveHandlerBtn(ActionEvent event) {
		// System.out.println("saveHandlerBtn");

		String facilityname = facilityName.getText();
		System.out.println("facilityname:" + facilityname);

		String selectdate = selectDate.getText();
		System.out.println("selectdate:" + selectdate);

		

		System.out.println();

	}
	
	
	  public void userinfoAction(ActionEvent event) throws Exception {
	        
//        lblStatus.setText("success"); // 로그인 성공
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage01_UserInfo.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage main = (Stage) userinfobtn.getScene().getWindow();
        main.close();     
     
 }
	
	
	
	  public void bookinghistoryAction(ActionEvent event) throws Exception {
        
//             lblStatus.setText("success"); // 로그인 성공
             Stage primaryStage = new Stage();
             Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage03_BookingHistory01.fxml"));
             Scene scene = new Scene(root);
             primaryStage.setScene(scene);
             primaryStage.show();

             Stage main = (Stage) bookinghistorybtn.getScene().getWindow();
             main.close();     
          
	  }
	  
	  public void bookinglistAction(ActionEvent event) throws Exception {
	        
//        lblStatus.setText("success"); // 로그인 성공
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage02_BookingList.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage main = (Stage) bookinglistbtn.getScene().getWindow();
        main.close();     
     
 }

}
