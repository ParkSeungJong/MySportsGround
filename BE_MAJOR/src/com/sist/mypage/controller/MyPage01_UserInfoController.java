package com.sist.mypage.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.sist.dto.workdiv.BE_Major;
import com.sist.facility.controller.MyBrowser;
import com.sist.hr.cmn.HROraConnectionMaker;
import com.sist.hr.member.dao.MemberDao;
import com.sist.hr.member.domain.MemberVO;
import com.sist.mypage.dao.UserDao;
import com.sist.mypage.dao.UserVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;
import com.sist.mypage.controller.LoginController;;


public class MyPage01_UserInfoController implements Initializable {

   @FXML TextField id;
   @FXML PasswordField pw;
   @FXML TextField userAddress;
   @FXML TextField userName;
   @FXML TextField userPhone;
   @FXML TextField userEmail;
   @FXML Button saveBtn;// 등록버튼
   @FXML Button cancelBtn;//취소버튼
   
   @FXML Button bookinglistbtn;
   @FXML Button userinfobtn;
   @FXML Button bookinghistorybtn;
   @FXML Button logOut;
   @FXML Button main;
   @FXML ImageView Logo;
   @FXML MenuButton comboBox;
   @FXML MenuItem hyper01,hyper02;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   if (LoginController.loginStatus == BE_Major.LOGIN) {// 로그인 상태
			id.setText(BE_Major.vo.getMemId());
			pw.setText(BE_Major.vo.getPw());
			userAddress.setText(BE_Major.vo.getAddress());
			userName.setText(BE_Major.vo.getName());
			userPhone.setText(BE_Major.vo.getCellphone());
			userEmail.setText(BE_Major.vo.getEmail());
		} else {
			System.out.println("로그인 할것");
			
		}
	   
	   
	// 로고 이미지 클릭시 메인페이지로 이동
	Logo.setOnMouseClicked(event -> MoveToMainPg(event));

	// 등록버튼 이벤트 감지
	saveBtn.setOnAction(event -> saveHandlerBtn(event));

	// 취소버튼 이벤트 감지
	cancelBtn.setOnAction(event -> cancelBtn(event));

	// 로그아웃 후 메인페이지 이동
	logOut.setOnAction(event -> logOutBtn(event));

	// 메인페이지버튼 클릭시 메인페이지로 이동(로그인상태)
	main.setOnAction(event -> myPgToMain(event));
   }
   
   // 상단 메인페이지버튼 클릭시 메인페이지로 이동(로그인상태)
   public void myPgToMain(ActionEvent event) {
	   Parent myPageLoad;
		try {
			myPageLoad = FXMLLoader.load(getClass().getResource("/com/sist/mainpage/view/MainPage.fxml"));
			Scene scene = new Scene(myPageLoad);
			Stage primaryStage = (Stage) main.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
	   }
	  
   }
      
   // 로그아웃 버튼 클릭시 로그아웃 된 후 메인페이지로 이동
   public void logOutBtn(ActionEvent event) {
	try {
		LoginController.loginStatus = 0;
		Parent myPageLoad = FXMLLoader.load(getClass().getResource("/com/sist/mainpage/view/MainPage.fxml"));
		Scene scene = new Scene(myPageLoad);
		Stage primaryStage = (Stage) logOut.getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
   }
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
   

 	//등록 버튼 이벤트 감지
   public void saveHandlerBtn(ActionEvent event) {
     // String ID = id.getText();
      String passwd = pw.getText();
      String Address = userAddress.getText();
      String Name = userName.getText();
      String Phone = userPhone.getText();
      String Email = userEmail.getText();
      
    
      
      
      MemberDao dao = new MemberDao(new HROraConnectionMaker());
      BE_Major.vo.setGrpDiv("5"); // 조 정보
      
      	BE_Major.vo.setPw(passwd);
      	BE_Major.vo.setAddress(Address);
      	BE_Major.vo.setName(Name);
      	BE_Major.vo.setCellphone(Phone);
      	BE_Major.vo.setEmail(Email);

		dao.do_update(BE_Major.vo);
	
   }
 

   
   
   
   //취소 버튼 이벤트 감지
   public void cancelBtn(ActionEvent event) {
      Stage main = (Stage) cancelBtn.getScene().getWindow();
      main.close(); 

   }
   
	//회원정보 버튼 클릭 시 해당페이지로 이동
     public void userinfoAction(ActionEvent event) throws Exception {
           
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage01_UserInfo.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage main = (Stage) userinfobtn.getScene().getWindow();
        main.close();     
        
     }
   
   //나의 예약내역 버튼 클릭 시 해당페이지로 이동
     public void bookinglistAction(ActionEvent event) throws Exception {
           
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage02_BookingList.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage main = (Stage) bookinglistbtn.getScene().getWindow();
        main.close();     
     }
     // 상단 '관련사이트'클릭시 해당 사이트 팝업창 띄우기
    	public void Hyperlink01(ActionEvent event) {

    		WebView web01 = new WebView();
    		WebEngine engine = web01.getEngine();

    		MyBrowser mybrowser = new MyBrowser();

    		Popup pop = new Popup();
    		Stage stage = (Stage) comboBox.getScene().getWindow();
    		// pop.setWidth(1200);
    		// pop.setHeight(800);
    		pop.getContent().add(mybrowser);
    		pop.setAutoHide(true);
    		pop.show(stage);

    	}
    	// 상단 '관련사이트'클릭시 해당 사이트 팝업창 띄우기
    	public void Hyperlink02(ActionEvent event) {

    		WebView web01 = new WebView();
    		WebEngine engine = web01.getEngine();

    		MyBrowser mybrowser = new MyBrowser();

    		Popup pop = new Popup();
    		Stage stage = (Stage) comboBox.getScene().getWindow();

    		pop.getContent().add(mybrowser);
    		pop.setAutoHide(true);
    		pop.show(stage);

    	}
        
   }

