package com.sist.mainpage.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPage extends Application {
	//fxml
	//load
	@Override
	public void start(Stage primaryStage) {
		// FXML load
		
		try {
		Parent	root = FXMLLoader.load(getClass().getResource("/com/sist/mainpage/view/MainPage.fxml"));
		//Scene에 추가
		Scene scene = new Scene(root);
		
		//stage에 추가
		primaryStage.setTitle("My Sports Ground 경기장 통합 예약 시스템");
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}

	public static void main(String[] args) {
		launch(args);

	}

}
