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

public class InsertController {
    
    // 목록
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    @FXML
    private TextArea tfContent;

    private BoardService boardService = new BoardServiceImpl();
    // 글쓰기 처리
    public void insert(ActionEvent event) throws IOException {
        Board board = new Board(tfTitle.getText(), tfWriter.getText(), tfContent.getText());
        int result = boardService.insert(board);
        if(result > 0) {
            System.out.println("글 등록 성공!");
            App.setRoot("board/list");
        }
    }
    
}
