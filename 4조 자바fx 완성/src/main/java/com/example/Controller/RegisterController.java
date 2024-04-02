package com.example.Controller;

import java.io.IOException;

import com.example.App;
import com.example.DTO.UserAccounts;
import com.example.Service.UserService;
import com.example.Service.UserServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisterController {

    @FXML
    private TextField ConfirmpwField; // 비밀번호 재 확인

    @FXML
    private TextField Email; // 이메일 입력

    @FXML
    private Button RegisterButton; // 등록 버튼

    @FXML
    private TextField UserField; // 이름 입력

    @FXML
    private Button closeButton; // 닫기 버튼

    @FXML
    private ToggleGroup gender; // 성별
    @FXML
    private RadioButton gender_female; // 여자
    @FXML
    private RadioButton gender_male; // 남자

    @FXML
    private Button idCheckbtn; // ID 중복 확인버튼

    @FXML
    private TextField idField; // ID 입력

    @FXML
    private Button pwCheckbtn; // 비밀번호 확인 체크

    @FXML
    private TextField pwField; // 비밀번호 입력

    @FXML
    private Label registerMessageLabel; // 확인 메시지

    private UserService userService = new UserServiceImpl();
    
    int idcheck = 0;  // 아이디 식별
    // 1 중복된 아이디 2 아이디생성가능

    int pwcheck = 0; // 비밀번호 식별
    //1 일치 2 불일치

    int NotnullCheck = 0;

    String genderDate = "";


    @FXML
    void idCheckBtnPressed(ActionEvent event) throws Exception{ 
        boolean isidCheck = userService.idCheck(idField.getText());
        String idStr = idField.getText();
        
        if(idStr.isEmpty()){
            registerMessageLabel.setText("Please enter your ID");
            System.out.println("아이디 공백!");
            idcheck = 1;

        }else{

            if(isidCheck){
                UserAccounts idCheck = userService.select(idField.getText());
    
                String userId = idCheck.getId();
                registerMessageLabel.setText(userId +" is an ID that already exists.");
                idcheck = 1;
            }
            else{
                registerMessageLabel.setText("This is an available ID.");
                idcheck = 2;
            }

        }
        
        
    }

  
    @FXML
    void pwCheckBtnPressed(ActionEvent event) {  // 비밀번호 확인
        String pwStr = pwField.getText();
        String CpwStr = ConfirmpwField.getText();

        if(pwStr.isEmpty()){
            registerMessageLabel.setText("Please enter your PW");
            pwcheck = 2;
        }else{
            if(pwStr.equals(CpwStr)){
                registerMessageLabel.setText("Your password matches");
                pwcheck = 1;
            }
            
            else{
                registerMessageLabel.setText("The passwords are not the same.");
                pwcheck = 2;
            }
        }

       
    }


    @FXML
    void genderSel(ActionEvent event) {
        
        if(gender_male.isSelected()){
            genderDate = "male";
           // registerMessageLabel.setText("남자");
        }
        if(gender_female.isSelected()){
            genderDate = "female";
          //  registerMessageLabel.setText("여자");
        }
    }

     
    @FXML
    void RegisterBtnPressed(ActionEvent event)  throws Exception {
        String EmailStr = Email.getText();
        String UserFieldStr = UserField.getText();

        if(UserFieldStr.isEmpty()){
            registerMessageLabel.setText("Please write your username!");
            NotnullCheck = 0;
        }else{
            NotnullCheck = 1;
        }

        if(EmailStr.isEmpty()) {
            NotnullCheck = 0;
            registerMessageLabel.setText("Please write your email!");
            
        }else{
            NotnullCheck = 1;
        }

        if(idcheck == 2 && pwcheck == 1 && NotnullCheck == 1 && genderDate.length() != 0){
        
            UserAccounts CreatUser = userService.insert(idField.getText(),pwField.getText(),UserField.getText(),genderDate,Email.getText());
            registerMessageLabel.setText("OK!");
        }
        else{
            registerMessageLabel.setText("Please enter the value or click the Check button.");
        }
     }

     @FXML
     void CloseBtnPressed(ActionEvent event) throws IOException{  // 로그인페이지로 돌아가기
        App.setRoot("board/login");
     }



}
