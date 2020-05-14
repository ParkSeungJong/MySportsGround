package com.sist.facility.controller;


import java.net.URL;

import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MyBrowser extends Region {
    final String hellohtml = "https://www.sist.co.kr/index.do";
    
       WebView webView = new WebView();
       
       WebEngine webEngine = webView.getEngine();
     
       public MyBrowser(){
    
    	  
           webEngine.load("https://www.sist.co.kr/index.do");
        
           getChildren().add(webView);
       }
}