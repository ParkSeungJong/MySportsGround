package com.sist.mypage.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sist.mypage.dao.BookingListDao;
import com.sist.mypage.dao.BookingListVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MyPage03_BookingHistoryController implements Initializable {

	@FXML TextField facilityName ;
	@FXML TextField facilityName2;
	@FXML TextField facilityName3;
	@FXML TextField selectDate;
	@FXML TextField selectDate2;
	@FXML TextField selectDate3;
	@FXML Button saveBtn;// 등록버튼
	@FXML Button bookinglistbtn;
	@FXML Button userinfobtn;
	@FXML Button bookinghistorybtn;
	@FXML ImageView imageView;
	@FXML ImageView imageView2;
	@FXML ImageView imageView3;
	@FXML ImageView Logo;
	
	public static List<BookingListVO> bookinglist;
	public static final String FILE_PATH  = "csv/bookinglist.csv";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//로고 이미지 클릭시 메인페이지로 이동	
		 Logo.setOnMouseClicked(event -> MoveToMainPg(event));
		
		BookingListDao bookinglistdao = new BookingListDao();
		BookingListVO bookinglistvo= new BookingListVO();
		bookinglist = new ArrayList<BookingListVO>();
		bookinglist = readFile(FILE_PATH);
		
		
		//경기장이름
	     String a =bookinglist.get(0).getFacilityName();
	     facilityName.setText(a);
	     
	     String b =bookinglist.get(5).getFacilityName();
	     facilityName2.setText(b);
	     
	     String c =bookinglist.get(6).getFacilityName();
	     facilityName3.setText(c);
		
		
	     String d =bookinglist.get(4).getSelectDate();
	     selectDate.setText(d);
	
	     String e =bookinglist.get(5).getSelectDate();
	     selectDate2.setText(e);
	     
	     String f =bookinglist.get(6).getSelectDate();
	     selectDate3.setText(f);
	     
	     
	     
	     Image image = new Image(getClass().getResourceAsStream("/img/SEO001_1.PNG")); 
	     imageView.setImage(image);
	     Image image2 = new Image(getClass().getResourceAsStream("/img/SEO002_1.jpg")); 
	     imageView2.setImage(image2);
	     Image image3 = new Image(getClass().getResourceAsStream("/img/SEO003_4.png")); 
	     imageView3.setImage(image3);
	     
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
				BookingListVO vo = new BookingListVO(dataArray[0], dataArray[1], dataArray[2],dataArray[3]);
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
		System.out.println("facilityName:" + facilityName);

		String selectdate = selectDate.getText();
		System.out.println("selectDate:" + selectDate);

		

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
