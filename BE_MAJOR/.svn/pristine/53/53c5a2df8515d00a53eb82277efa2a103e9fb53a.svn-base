package com.sist.mypage.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyPage02_BookingListMain extends Application {

	// fxml
	// load

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/sist/mypage/view/MyPage02_BookingList.fxml"));
			Scene scene = new Scene(root);
//            URL url = getClass().getResource("/app.css");
//    		scene.getStylesheets().add(url.toString());

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}
