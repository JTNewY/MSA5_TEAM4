package com.example.DTO;

/* 유저 관리 DB
 * 
 * IDUSERACCOUNT,ID,PASSWORD,USERNAME,GENDER,EMAIL
 */

public class UserAccounts {
    
    // 테이블 컬럼과 똑같이 변수 선언
    // getter setter

    private int idUserAccount;
    private String id;
    private String password;
    private String username;
    private String gender;
    private String email;

    //생성자
    public UserAccounts(){
        this("아이디","비밀번호","이름","성별","이메일");
    }

    public UserAccounts(String id,String password,String username,String gender,String email){
        this.id = id;
        this.password = password;
        this.username = username;
        this.gender = gender;
        this.email = email;
    }   

    //getter setter
    public int getIdUserAccount() {
        return idUserAccount;
    }

    public void setIdUserAccount(int idUserAccount) {
        this.idUserAccount = idUserAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
