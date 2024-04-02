package com.example.Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.App;
import com.example.DTO.UserAccounts;
import com.example.Service.UserService;
import com.example.Service.UserServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class Logincontroll implements Initializable {

    @FXML
    private Button LoginBtn; // 로그인 버튼
     @FXML
    private TextField idField; // ID창
    @FXML
    private Label loginMessageLabel; //로그인 성공 실패 여부
    @FXML
    private TextField pwField2; // 비밀번호 보이는창
    
    @FXML
    private PasswordField pwField; //비밀번호 창

    @FXML
    private Button regField; // 회원가입    
    @FXML
    private CheckBox ShownPW; // 비밀번호 보이기

    private UserService userService = new UserServiceImpl();

    

    @FXML // 버튼 눌럿을때
    void LoginBtnPressed(ActionEvent event) throws Exception {

        if(ShownPW.isSelected()){ // 비밀번호 가리기 눌렀을때 실행!
            boolean isLogin = userService.login(idField.getText(), pwField2.getText());
            if(isLogin){
                // loginMessageLabel.setText("Welcome!");
                UserAccounts loginUser = userService.select(idField.getText());
    
                String userId = loginUser.getId();
                loginMessageLabel.setText("Welcome! "+ userId );
                
                
                showAlert("알림", userId +"Welcome!", Alert.AlertType.INFORMATION);
                App.setRoot("board/list");
                return;
            }else{
                loginMessageLabel.setText("Invalid Login. Please try again");
            }
        }else{  // 비밀번호 가리기 안눌렀을때 실행!
            boolean isLogin = userService.login(idField.getText(), pwField.getText());
            if(isLogin){
                // loginMessageLabel.setText("Welcome!");
                UserAccounts loginUser = userService.select(idField.getText());
    
                String userId = loginUser.getId();
                loginMessageLabel.setText("Welcome! "+ userId ); 
                
                showAlert("알림", userId +"Welcome!", Alert.AlertType.INFORMATION);
                App.setRoot("board/list");

                return;
            }else{
                loginMessageLabel.setText("Invalid Login. Please try again");
            }
        }
       
        
        // if(idField.getText().isBlank() == false && pwField.getText().isBlank() == false ){
        //     /*  loginMessageLabel.setText("You try to login!"); */
        //     // ID창 비밀번호창 비엇을경우
        //     loginMessageLabel.setText("You try to login!");
        // } else{
        //     loginMessageLabel.setText("Please enter id and password.");
        // }
    }

    @FXML
    void moveToInsert(ActionEvent event) throws IOException {
        App.setRoot("board/memberRegister");
    }

    @FXML
    void handleOptions(ActionEvent event) {
        if(ShownPW.isSelected()){ // 비밀번호 보이게 하기
            System.out.println("비밀번호 보이게 하기!");
            
            String data = pwField.getText();
            pwField2.setText(data);

            pwField.setVisible(false);
            pwField2.setVisible(true);
           
        }
        else{ // 비밀번호 안보이게 하기
            System.out.println("비밀번호 안보이게 하기!");
            
            String data = pwField2.getText();
            pwField.setText(data);

            pwField.setVisible(true);
            pwField2.setVisible(false);
            
        }
    }

      @FXML
    void passwordFieldKeyTyped(KeyEvent event) {
      
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        pwField.setVisible(true);
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
