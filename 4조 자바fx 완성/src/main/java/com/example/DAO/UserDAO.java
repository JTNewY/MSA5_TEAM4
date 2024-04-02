package com.example.DAO;

import java.sql.SQLException;

import com.example.DTO.UserAccounts;

public class UserDAO extends JDBConnection {

    /**
     * 로그인
     * @param id
     * @param password
     * @return
     */
    public boolean login(String id, String password) {
        UserAccounts users = new UserAccounts();

        // id pw 가 일치하는 조건에 sql 짜고 조회
        // 1개라도 존재하면 return true
        // 없으면 false

        String sql = "SELECT count(*) cnt FROM UserAccounts WHERE id= ? AND  password = ?" ;
        try {
           psmt = con.prepareStatement(sql); //실행
            psmt.setString(1, id);
            psmt.setString(2, password);

           rs = psmt.executeQuery(); //결과

           while( rs.next() ) {
            if(rs.getInt("cnt") == 1){
                System.out.println("로그인성공 = DAO");
                           // 로그인 성공
                return true;
            }else{
            System.out.println("로그인실패 = DAO");
            return false;
           }
        }

        //    while (rs.next()) { // id pw 가 일치하는 조건
        //     if(rs.getInt(1) == 1){
        //         loginMessageLabel.setText("Welcome!");
                

        //         return true;
        //     }
        //     else{
        //         loginMessageLabel.setText("Invalid Login. Please try again");
        //         return false;
        //     }
        //    }
             } 
         catch (Exception e){ //예외 발생시
            e.printStackTrace();
        }

        return false;       // 로그인 실패
    }


    /**
     * 유저 정보 조회
     * @param id
     * @return
     */
    public UserAccounts select(String id) {
        UserAccounts user = new UserAccounts();

        String sql = " SELECT * FROM UserAccounts WHERE id = ? ";

        try {
            psmt = con.prepareStatement(sql); //실행
            psmt.setString(1, id);

            rs = psmt.executeQuery(); //결과

            if( rs.next() ) {
                String userId = rs.getString("id");
                // 계정 추가정보 넣기

                user.setId(userId);
            }
            else{
                return user;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return user;
    }

    // 아이디 중복여부 확인

    public boolean idCheck(String id){
        UserAccounts users = new UserAccounts();

        String sql = "SELECT count(*) cnt FROM UserAccounts WHERE id= ?";

        try{
            psmt = con.prepareStatement(sql);
            psmt.setString(1, id);

            // 0 이면 아이디 생성 가능 , 1 이면 중복
            rs = psmt.executeQuery();
            while (rs.next()) {
                if(rs.getInt("cnt") == 1){
                    System.out.println("중복된 아이디가 있습니다");
                               // 로그인 성공
                    return true;
                }else{
                System.out.println("아이디 생성가능합니다");
                return false;
               }
            }

        }catch (Exception e) { 

        }


        return false;
    }

    // 회원 가입 
   public UserAccounts insert(String id,String password,String username, String gender,String email ){
    UserAccounts user = new UserAccounts();

    String sql = "INSERT INTO UserAccounts (IDUSERACCOUNT, id,password,username,gender,email) "
                + " VALUES(SEQ_USER.nextval, ?,?,?,?,?)";
        try{
            psmt = con.prepareStatement(sql);
            psmt.setString(1,id);
            psmt.setString(2,password);
            psmt.setString(3,username);
            psmt.setString(4,gender);
            psmt.setString(5,email);

            psmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("유저 등록, 예외발생");
            e.printStackTrace();
        }

    return user;
   }

}
