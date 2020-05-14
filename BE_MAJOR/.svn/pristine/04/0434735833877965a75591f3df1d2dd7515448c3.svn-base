package com.sist.booking.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sist.booking.dao.BookingDAO;
import com.sist.facility.controller.MyBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Booking02_listController implements Initializable {
	BookingDAO dao = new BookingDAO();

	Alert alert = new Alert(AlertType.WARNING);
	@FXML
	Button findBtn, bookBtn1, bookBtn2, MyPgBtn, loginbtn;
	@FXML
	TextField tfArea, tfDate, tfName1, tfName2;
	@FXML
	Text txtDate1, txtDate2, txtAdd1, txtAdd2;
	@FXML
	Rectangle Rec1, Rec2;
	@FXML
	ImageView Logo, imgView1, imgView2;
	@FXML
	MenuItem hyper01, hyper02;
	@FXML
	MenuButton comboBox;

	public static String bookingFsName;// 예약하는 경기장이름
	public static String date;// 예약하는 경기장이름날짜
	public static String address;// 예약하는 경기장이름주소
	public static String code;// 예약하는 경기장코드

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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 로고 이미지 클릭시 메인페이지로 이동
		Logo.setOnMouseClicked(event -> MoveToMainPg(event));
		// '마이페이지' 버튼 클릭시 마이페이지로 이동
		MyPgBtn.setOnAction(event -> MoveToMyPg(event));

		findBtn.setOnAction(event -> findAction(event));
		bookBtn1.setOnAction(event1 -> bookAction1(event1));
		bookBtn2.setOnAction(event2 -> bookAction2(event2));
		alert.setTitle("MSG");
		alert.setHeaderText("Look, a Dialog");

	}

	public void bookAction1(ActionEvent event1) {
		//예약가능이  false 일때 버튼메세지
		if (dao.do_retrieveBookBtn1(tfArea.getText(), tfDate.getText())) {
			alert.setContentText("예약이 불가합니다.");
			alert.showAndWait();
		}

	}

	public void bookAction2(ActionEvent event2) {
		//예약가능이 true 일때 다음페이지 진행
		if (dao.do_retrieveBookBtn2(tfArea.getText(), tfDate.getText()) == false) {
			try {
				alert.setContentText("예약을 진행합니다.");
				alert.showAndWait();

				Parent second = FXMLLoader
						.load(getClass().getResource("/com/sist/booking/view/Booking03_UserInformation.fxml"));
				Scene scene = new Scene(second);
				Stage primaryStage = (Stage) bookBtn2.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void findAction(ActionEvent event) {
		alert.setContentText("지역: " + tfArea.getText() + "\n날짜 :" + tfDate.getText() + "\n예약을 검색합니다.");
		alert.showAndWait();

		String path1 = dao.do_retrieveImagePath1(tfArea.getText(), tfDate.getText());
		String path2 = dao.do_retrieveImagePath2(tfArea.getText(), tfDate.getText());

		tfName1.setText(dao.do_retrieveName1(tfArea.getText(), tfDate.getText()));
		tfName2.setText(dao.do_retrieveName2(tfArea.getText(), tfDate.getText()));
		txtDate1.setText(dao.do_retrieveDate1(tfArea.getText(), tfDate.getText()));
		txtDate2.setText(dao.do_retrieveDate2(tfArea.getText(), tfDate.getText()));
		txtAdd1.setText(dao.do_retrieveAddress1(tfArea.getText(), tfDate.getText()));
		txtAdd2.setText(dao.do_retrieveAddress2(tfArea.getText(), tfDate.getText()));
		Rec1.setFill(dao.do_retrieveColor1(tfArea.getText(), tfDate.getText()));
		Rec2.setFill(dao.do_retrieveColor2(tfArea.getText(), tfDate.getText()));
		imgView1.setImage(new Image(path1));
		imgView2.setImage(new Image(path2));

		// 키값 - do_selectOne 함수써서 해당 한줄 읽어오면됨.
		bookingFsName = dao.do_retrieveName2(tfArea.getText(), tfDate.getText());
		date = dao.do_retrieveDate2(tfArea.getText(), tfDate.getText());
		address = dao.do_retrieveAddress2(tfArea.getText(), tfDate.getText());

		code = dao.do_retrievecode(tfArea.getText(), tfDate.getText());

	}

}
