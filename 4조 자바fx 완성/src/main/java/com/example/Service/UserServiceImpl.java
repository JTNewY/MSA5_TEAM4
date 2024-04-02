package com.example.Service;

import com.example.DAO.UserDAO;
import com.example.DTO.UserAccounts;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAO();

    @Override
    public boolean login(String id, String password) throws Exception {
        boolean isLogin = userDAO.login(id, password);

        if( isLogin ) {
            System.out.println("Welcome!");
        
            return true;
        }
        else {
          System.out.println("Invalid Login. Please try again");
          return false;
        }
 
        
    }

    //아이디 체크
    public boolean idCheck(String id) throws Exception{
        boolean isidCheck = userDAO.idCheck(id);

        if(isidCheck){
            System.out.println("중복있음");

            return true;
        }
        else{
            System.out.println("중복없음");
            return false;
        }

    }


    @Override
    public UserAccounts insert(String id, String password,String username,String gender,String email) {
        UserAccounts result = userDAO.insert(id,password,username,gender,email);
        // 2. 적용된 데이터 건수를 반환
		// - 결과 :	0 --> 데이터 등록 실패
		// -		1 --> 데이터 등록 성공
        return result;
    }

    @Override
    public UserAccounts select(String id) throws Exception {
        UserAccounts user = userDAO.select(id);

        return user;
    }
    
}
