package com.sist.mypage.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.sist.hr.member.domain.MemberVO;
import com.sist.hr.cmn.HROraConnectionMaker;
import com.sist.hr.member.dao.MemberDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sist.dto.workdiv.BE_Major;
import com.sist.hr.cmn.ConnectionMaker;
import com.sist.hr.cmn.DTO;
import com.sist.hr.cmn.JDBCUtil;
import com.sist.hr.cmn.SearchVO;
import com.sist.hr.cmn.WorkDiv;
import com.sist.hr.member.domain.MemberVO;
public class LoginController implements Initializable {
	private static final String String = null;
	@FXML Button loginBtn,lbtn;
	@FXML TextField idTxt;			//id입력
	@FXML PasswordField passTxt;	//비번입력 필드
	@FXML Hyperlink Login,LogOut;
	Alert alert = new Alert(AlertType.WARNING);
	public static String userId;		//회원 아이디
	public static String userPw;		//회원 비밀번호
	public static String userNm;		//회원 이름
	public static String userMail;		//회원 이메일
	public static String userAdd;		//회원 주소
	public static String userCellphone;	//회원 번호
	public static String userAuth;		//회원모드(이용자,관리자)
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		alert.setTitle("WELCOME TO MSG");	//제목
		alert.setHeaderText("Look, BE_MAJOR Dialog");
		//이벤트 감지
		//loginEvent감지
	}
	
	public void MoveToLgPg(ActionEvent event) {
		
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/LoginPage.fxml"));			
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
			
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void loginHandelerBtn(ActionEvent event) {
		MemberDao dao = new MemberDao(new HROraConnectionMaker());
		String memId = idTxt.getText().trim();
		//ID 입력 Validation
		if(memId==null||"".equals(memId)) {
			alert.setContentText("아이디를 입력하세요.");
			alert.showAndWait();
			idTxt.requestFocus();
			
			
			return;
		}
	
		//비번 Validation
				String pass = this.passTxt.getText().trim();
				if(pass==null||"".equals(pass)) {
					alert.setContentText("비번을 입력하세요.");
					alert.showAndWait();
					passTxt.requestFocus();
					
					return;
				}
				
				MemberVO inVO = new MemberVO();
				inVO.setGrpDiv("5");  	//조 정보
				inVO.setMemId(memId);	//ID
				inVO.setPw(pass);		//비번
				
				//Login
				MemberVO outVO  = dao.do_login(inVO);
				if(outVO.getMessageDiv().equals("11")) {
					userId 		    = outVO.getMemId();
					userPw			= outVO.getPw();
					userNm			= outVO.getName();
					userMail		= outVO.getEmail();
					userAdd			= outVO.getAddress();
					userCellphone	= outVO.getCellphone();
					userAuth		= outVO.getAuth();
					
					BE_Major.vo = outVO;
					
					alert.setContentText(outVO.getMessage());
					alert.showAndWait();
					
				
				
				try {		
					Parent myPageLoad = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage01_UserInfo.fxml"));
					Scene scene = new Scene(myPageLoad);
					Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
					primaryStage.setScene(scene);
					primaryStage.show();
					
				} catch (IOException e) {
					e.printStackTrace();
				} 
				}//--if
				else {
					alert.setContentText(outVO.getMessage());
					alert.showAndWait();
					return;
				}
	}
	
  }