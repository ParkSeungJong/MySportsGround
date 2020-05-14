package com.sist.facility.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sist.facility.dao.FacilityDAO;
import com.sist.facility.dao.FacilityVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Facility01_ListController02 implements Initializable {

	@FXML ImageView Logo, fImage03,fImage04;
	@FXML Button MyPgBtn, loginbtn, page1;
	@FXML TextField fName03, fName04;
	@FXML Text fAddress03, fSize03, fPhone03, fArea03, fAddress04, fSize04, fPhone04, fArea04;
	@FXML Button detail03,detail04;
	@FXML MenuItem hyper01, hyper02;
	@FXML MenuButton comboBox;

	public static List<FacilityVO> facilityList; 
	public static final String FILE_PATH = "csv/facilityinfo.csv";

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

	//상단 '마이페이지' 버튼 클릭시 메인페이지로 이동
	public void MoveToMyPg(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage01_UserInfo.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) MyPgBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//상단 '로그인' 버튼 클릭시 메인페이지로 이동
	public void MoveToLgPg(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/LoginPage.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) loginbtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//상단 '관련사이트'클릭시 해당 사이트 팝업창 띄우기
		public void Hyperlink01(ActionEvent event) {

			WebView web01=new WebView();
			WebEngine engine=web01.getEngine();

			MyBrowser mybrowser=new MyBrowser();


			Popup pop=new Popup();
			Stage stage=(Stage)comboBox.getScene().getWindow();
			//		pop.setWidth(1200);
			//		pop.setHeight(800);
			pop.getContent().add(mybrowser);
			pop.setAutoHide(true);
			pop.show(stage);

		}

		public void Hyperlink02(ActionEvent event) {

			WebView web01=new WebView();
			WebEngine engine=web01.getEngine();

			MyBrowser mybrowser=new MyBrowser();

			Popup pop=new Popup();
			Stage stage=(Stage)comboBox.getScene().getWindow();

			pop.getContent().add(mybrowser);
			pop.setAutoHide(true);
			pop.show(stage);

		}


	//첫번째 상세버튼 클릭시 상세페이지로 이동	
	public void MoveToDetail03(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/facility/view/Facility02_Infomation001.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) detail03.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//두번째 상세버튼 클릭시 상세페이지로 이동	
	public void MoveToDetail04(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/facility/view/Facility02_Infomation002.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) detail04.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//'1' 버튼 클릭시 시설목록 1 페이지로 이동
	public void MoveToPg1(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/facility/view/Facility01_List.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) page1.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//로고 이미지 클릭시 메인페이지로 이동	
		Logo.setOnMouseClicked(event -> MoveToMainPg(event));

		//'마이페이지' 버튼 클릭시 마이페이지로 이동
		MyPgBtn.setOnAction(event -> MoveToMyPg(event));
		//첫번째'상세보기' 버튼 클릭시 상세페이지로 이동
		detail03.setOnAction(event -> MoveToDetail03(event));

		//두번째'상세보기' 버튼 클릭시 상세페이지로 이동
		detail04.setOnAction(event -> MoveToDetail04(event));


		//'2'누르면 2


		//UI에 경기장 데이터 넣기
		FacilityVO vo = new FacilityVO();
		FacilityDAO fDao = new FacilityDAO();
		facilityList  = new ArrayList<FacilityVO>();
		facilityList = fDao.readFile(FILE_PATH);

		//경기장 이름3
		String a01 =facilityList.get(2).getFacilityName();
		fName03.setText(a01); 
		//경기장 주소3
		String a02 = facilityList.get(2).getFacilityAddress();
		fAddress03.setText(a02);	    
		//경기장 규격3
		String a03 = facilityList.get(2).getFacilitySize();
		fSize03.setText(a03);	    
		//경기장 전화번호3
		String a04 = facilityList.get(2).getFacilityPhone();
		fPhone03.setText(a04);	    
		//경기장 이미지3
		String a06 = facilityList.get(2).getFacilityImg1().trim();	    
		fImage03.setImage(new Image(a06));
		//경기장 주소3
		String a07 = facilityList.get(2).getFacilityArea();
		fArea03.setText(a07);


		//경기장 이름4
		String b01 =facilityList.get(3).getFacilityName();
		fName04.setText(b01); 
		//경기장 주소4
		String b02 = facilityList.get(3).getFacilityAddress();
		fAddress04.setText(b02);	    
		//경기장 규격4
		String b03 = facilityList.get(3).getFacilitySize();
		fSize04.setText(b03);	    
		//경기장 전화번호4
		String b04 = facilityList.get(3).getFacilityPhone();
		fPhone04.setText(b04);	    
		//경기장 이미지4
		String b06 = facilityList.get(3).getFacilityImg1().trim();	    
		fImage04.setImage(new Image(b06));
		//경기장 주소4
		String b07 = facilityList.get(3).getFacilityArea();
		fArea04.setText(b07);


	}


}


