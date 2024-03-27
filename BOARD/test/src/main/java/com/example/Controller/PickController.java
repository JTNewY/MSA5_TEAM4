package com.example.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.App;
import com.example.DTO.Board;
import com.example.Service.BoardService;
import com.example.Service.BoardServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PickController implements Initializable {
    
    @FXML
    public TableView<Board> boardTableView;
    
    @FXML
    public TextField<Board, Integer> pickNo;
    @FXML
    public TableColumn<Board, String> colTitle;
    @FXML
    public TableColumn<Board, String> colWriter;
    @FXML
    public TableColumn<Board, String> colRegDate;
    @FXML
    public TextArea<Board, String> content;

    private BoardService boardService = new BoardServiceImpl();

    
    @FXML
    void moveToPick(ActionEvent event) throws IOException {
        App.setRoot("board/pick");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // 게시글 목록 조회
        Board board = boardService.select(no);

		colTitle.setCellValueFactory( new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory( new PropertyValueFactory<>("Writer"));
		colRegDate.setCellValueFactory( new PropertyValueFactory<>("RegDate"));
		content.setCellValueFactory( new PropertyValueFactory<>("View"));
		
		// 테이블뷰에 데이터 추가하기
		ObservableList<Board> list = FXCollections.observableArrayList(
            board
		);
		
		boardTableView.setItems(list);
    }
    
}
