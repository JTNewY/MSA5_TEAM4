package com.example.Controller;

import java.io.IOException;

import com.example.App;
import com.example.DTO.Board;
import com.example.Service.BoardService;
import com.example.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SerchController {
    
    private BoardService boardService = new BoardServiceImpl();

    @FXML
    private TextArea tfContent;

    @FXML
    private TextField tfNo;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    @FXML
    public void find(ActionEvent event) {
     Board board = new Board();
     int board_No = Integer.parseInt(tfNo.getText());
      board = boardService.select(board_No);

      //만약 검색된 게시글이 존재한다면 출력
      if(board != null) {
         //해당 게시판을 출력하는 코드작성
        System.out.println(board);
        tfTitle.setText(board.getTitle());
        tfWriter.setText(board.getWriter());
        tfContent.setText(board.getContent());
 
      }else{
         System.out.println("해당번호의 게시판이 존재하지 않습니다.");
      }
  
    }
    
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }  
}
