package com.team4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

import com.team4.DAO.JDBConnection;

/**
 * JavaFX App
 */
public class UI extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try{
        scene = new Scene(loadFXML("UI"));
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            // 기본 이벤트(프로그램 종료) 제거
            // "consume" : 소멸시키다
            event.consume();
            //메소드 호출
            logout(stage);
        });
        
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
         JDBConnection jdbc = new JDBConnection();
        launch();
    }
    
    public static void logout(Stage stage) {
		System.out.println("click logout......");
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("로그아웃을 진행합니다.");
		alert.setContentText("종료 전에 저장하시겠습니까?");
		
		// 경고창에서 OK 버튼 클릭 시
		if(alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("프로그램을 종료합니다....");
			stage.close();
		}
	}
}