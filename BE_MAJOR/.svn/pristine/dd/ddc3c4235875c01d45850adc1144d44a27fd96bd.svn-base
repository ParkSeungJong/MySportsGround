package com.sist.booking.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sist.booking.dao.BookingDAO;
import com.sist.booking.dao.BookingVO;
import com.sist.facility.controller.MyBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Booking03_UserInformationController implements Initializable {
	Alert alert = new Alert(AlertType.WARNING);

	BookingDAO dao = new BookingDAO();
	Booking02_listController blc = new Booking02_listController();
	String code = Booking02_listController.code;
	
	@FXML
	Text txtDate, txtFsName, txtAddress, txtId;
	@FXML
	Button bookBtn, MyPgBtn, loginbtn;
	@FXML
	TextField tfTeam, tfUserNumber, tfUserName;
	@FXML
	CheckBox check1, check2;
	@FXML
	ImageView Logo;
	@FXML
	MenuItem hyper01, hyper02;
	@FXML
	MenuButton comboBox;

	public static String team;
	public static String userNum;
	public static String userName;
	public static String userId;

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

		alert.setTitle("MSG");
		alert.setHeaderText("Look, a Dialog");

		bookBtn.setOnAction(event -> bookBtnAction(event));

		String bookingFsName = Booking02_listController.bookingFsName;
		String date = Booking02_listController.date;
		String address = Booking02_listController.address;

		txtDate.setText(date);
		txtFsName.setText(bookingFsName);
		txtAddress.setText(address);

		txtId.setText(null); // 아이디값 불러오기

	}

	public void bookBtnAction(ActionEvent event) {

		try {
			if (check1.isSelected() == true && check2.isSelected() == true) {

				alert.setContentText("예약을 완료하였습니다.");
				alert.showAndWait();

				// team = tfTeam.getText();
				userNum = tfUserNumber.getText();
				userName = tfUserName.getText();
				userId = txtId.getText();

				// 01 검색할 키값
				BookingVO vo = new BookingVO();
				vo = dao.getInputfCode(code);

				// 02 업데이트 할 값을 정제.
				BookingVO resultVO = new BookingVO();
				resultVO = dao.do_selectOne2(vo);
				resultVO.setUserId("TEST");
				resultVO.setUserName(tfUserName.getText());
				resultVO.setUserPhoneNumber(tfUserNumber.getText());

				// 03 코드값을 키로 삭제 후 정제한 값으로 저장.
				 dao.do_update(resultVO);

				Parent second = FXMLLoader
						.load(getClass().getResource("/com/sist/booking/view/Booking04_Complete.fxml"));
				Scene scene = new Scene(second);
				Stage primaryStage = (Stage) bookBtn.getScene().getWindow();
				primaryStage.setScene(scene);

			} else {
				alert.setContentText("개인정보, 이용약관을 동의해주세요.");
				alert.showAndWait();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
