package com.sist.facility.controller;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Facility02_InfoController002 implements Initializable {
	@FXML Label historyLabel,wayLabel;
	@FXML Text  year01,year02,year03,year04,year05,year06,
	history01,history02,history03,history04,history05,history06,
	subway,bus01,bus02,bus03,bus04,car01,car02,inquary01,inquary02;
	@FXML ImageView Logo;
	@FXML Button MyPgBtn, loginbtn,BookingBtn;
	@FXML MenuItem hyper01, hyper02;
	@FXML MenuButton comboBox;
	@FXML Hyperlink hyper;

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

	//해당 경기장 사이트 이동 hyperlink
	public void MoveToWeb(ActionEvent event) {

		WebView web01=new WebView();
		WebEngine engine=web01.getEngine();	
		MyBrowser mybrowser=new MyBrowser();
		Popup pop=new Popup();
		Stage stage=(Stage)hyper.getScene().getWindow();

		pop.getContent().add(mybrowser);
		pop.setAutoHide(true);
		pop.show(stage);
	}

	// '예약하기' 버튼 클릭시 예약페이지로 이동
	public void MoveToBooking(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/booking/view/Booking02_list.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) BookingBtn.getScene().getWindow();
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

		//'예약하기' 버튼 클릭시 마이페이지로 이동
		BookingBtn.setOnAction(event -> MoveToBooking(event));

		//연혁
		FacilityDAO yeardao = new FacilityDAO();
		ArrayList<FacilityVO> list= (ArrayList<FacilityVO>) yeardao.do_read("csv/facilityHistory.csv");

		Text[]yearList = {year01,year02,year03,year04,year05,year06}; 
		Text[] historyList={history01,history02,history03,history04,history05,history06};
		for(int i=0;i<list.size();i++) {
			yearList[i].setText(list.get(i).getFirst_col());
			historyList[i].setText(list.get(i).getSecond_col());
		}

		//오시는 길
		FacilityDAO way = new FacilityDAO();
		ArrayList<FacilityVO> wayList= (ArrayList<FacilityVO>) way.do_read("csv/facilityway.csv");
		Text[] Way = {subway,bus01,bus02,bus03,bus04,car01,car02};
		for(int i=0;i<wayList.size();i++) {
			Way[i].setText(wayList.get(i).getSecond_col());
		}

		//안내 및 문의
		FacilityDAO inquary = new FacilityDAO();
		ArrayList<FacilityVO> inqList= (ArrayList<FacilityVO>) way.do_read("csv/facilityinquiry.csv");
		Text[] inq = {inquary01,inquary02};
		for(int i=0;i<inqList.size();i++) {
			inq[i].setText(inqList.get(i).getSecond_col());
		}
	}
}
