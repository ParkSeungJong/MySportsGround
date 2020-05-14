package com.sist.booking.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sist.facility.controller.MyBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Booking04_CompleteController implements Initializable {

	@FXML
	Text txtAddress, txtFsName, txtDate, txtUserId, txtUserNumber, txtUserName, txtTeamName;
	@FXML
	ImageView Logo;
	@FXML
	Button MyPgBtn, loginbtn;
	@FXML
	MenuItem hyper01, hyper02;
	@FXML
	MenuButton comboBox;

	// 상단 로고 클릭시 메인페이지로 이동
	public void MoveToMainPg(MouseEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mainpage/view/MainPage.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) Logo.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 상단 '마이페이지' 버튼 클릭시 메인페이지로 이동
	public void MoveToMyPg(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage01_UserInfo.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) MyPgBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 상단 '로그인' 버튼 클릭시 메인페이지로 이동
	public void MoveToLgPg(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/LoginPage.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = (Stage) loginbtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 로고 이미지 클릭시 메인페이지로 이동
		Logo.setOnMouseClicked(event -> MoveToMainPg(event));
		// '마이페이지' 버튼 클릭시 마이페이지로 이동
		MyPgBtn.setOnAction(event -> MoveToMyPg(event));

		String bookingFsName = Booking02_listController.bookingFsName;
		String date = Booking02_listController.date;
		String address = Booking02_listController.address;

		String team = Booking03_UserInformationController.team;
		String userNum = Booking03_UserInformationController.userNum;
		String userName = Booking03_UserInformationController.userName;
		String userId = Booking03_UserInformationController.userId;

		txtAddress.setText(address);
		txtFsName.setText(bookingFsName);
		txtDate.setText(date);

		txtTeamName.setText(team);
		txtUserNumber.setText(userNum);
		txtUserName.setText(userName);
		txtUserId.setText(userId);
	}

}
