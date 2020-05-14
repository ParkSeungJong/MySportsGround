package com.sist.facility.controller;

import java.io.File;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Facility01_ListController  implements Initializable  {

	@FXML ImageView Logo, fImage01,fImage02;
	@FXML Button MyPgBtn, loginbtn, page2,detail01,detail02;
	@FXML TextField fName01, fName02;
	@FXML Text fAddress01, fSize01, fPhone01,fArea01, fAddress02, fSize02, fPhone02,fArea02;
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
	public void MoveToDetail01(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/facility/view/Facility02_Infomation001.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) detail01.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//두번째 상세버튼 클릭시 상세페이지로 이동	
	public void MoveToDetail02(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/facility/view/Facility02_Infomation002.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) detail02.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//'2' 버튼 클릭시 시설목록 2 페이지로 이동
	public void MoveToPg2(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/facility/view/Facility01_List02.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) page2.getScene().getWindow();
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
		detail01.setOnAction(event -> MoveToDetail01(event));

		//두번째'상세보기' 버튼 클릭시 상세페이지로 이동
		detail02.setOnAction(event -> MoveToDetail02(event));


		//UI에 데이터 넣기
		FacilityVO vo = new FacilityVO();
		FacilityDAO fDao = new FacilityDAO();
		facilityList  = new ArrayList<FacilityVO>();
		facilityList = fDao.readFile(FILE_PATH);


		//경기장 이름1
		String a01 =facilityList.get(0).getFacilityName();
		fName01.setText(a01); 
		//경기장 주소1
		String a02 = facilityList.get(0).getFacilityAddress();
		fAddress01.setText(a02);	    
		//경기장 규격1
		String a03 = facilityList.get(0).getFacilitySize();
		fSize01.setText(a03);	    
		//경기장 전화번호1
		String a04 = facilityList.get(0).getFacilityPhone();
		fPhone01.setText(a04);	    
		//경기장 이미지1
		String a06 = facilityList.get(0).getFacilityImg1().trim();	    
		fImage01.setImage(new Image(a06));
		//경기장 주소1
		String a07 = facilityList.get(0).getFacilityArea();
		fArea01.setText(a07);


		//경기장 이름2
		String b01 =facilityList.get(1).getFacilityName();
		fName02.setText(b01); 
		//경기장 주소2
		String b02 = facilityList.get(1).getFacilityAddress();
		fAddress02.setText(b02);	    
		//경기장 규격2
		String b03 = facilityList.get(1).getFacilitySize();
		fSize02.setText(b03);	    
		//경기장 전화번호2
		String b04 = facilityList.get(1).getFacilityPhone();
		fPhone02.setText(b04);	    
		//경기장 이미지2
		String b06 = facilityList.get(1).getFacilityImg1().trim();	    
		fImage02.setImage(new Image(b06));
		//경기장 주소2
		String b07 = facilityList.get(1).getFacilityArea();
		fArea02.setText(b07);


	}


}