package com.example.Service;

import com.example.DTO.UserAccounts;

public interface UserService {
    
    // 로그인
    public boolean login(String id, String password) throws Exception;

    // 회원 조회
    public UserAccounts select(String id) throws Exception;

    // 회원 가입
    public UserAccounts insert(String id, String password,String username,String gender,String email);

    //아이디 체크
    public boolean idCheck(String id) throws Exception;


}
