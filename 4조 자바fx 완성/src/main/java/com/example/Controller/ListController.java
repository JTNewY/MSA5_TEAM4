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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListController implements Initializable {
    @FXML
    public TableView<Board> boardTableView;
    
    @FXML
    public TableColumn<Board, Integer> colNo;
    @FXML
    public TableColumn<Board, String> colTitle;
    @FXML
    public TableColumn<Board, String> colWriter;
    @FXML
    public TableColumn<Board, String> colRegDate;
    @FXML
    public Label loginMessage;
 

    private BoardService boardService = new BoardServiceImpl();


    @FXML
    void moveToInsert(ActionEvent event) throws IOException {
        App.setRoot("board/Insert");
        // SceneUtil.getInstance().switchScene(event, UI.INSERT.getPath());
    }

    // 번호로 조회하기
    @FXML
    void selectInsert(ActionEvent event) throws IOException {
        App.setRoot("board/search");
    }

    // 수정 삭제
    @FXML
    void moveToDelete(ActionEvent event) throws IOException {
        App.setRoot("board/delete");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 게시글 목록 조회
        List<Board> boardList = boardService.list();

        colNo.setCellValueFactory( new PropertyValueFactory<>("No"));
		colTitle.setCellValueFactory( new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory( new PropertyValueFactory<>("Writer"));
		colRegDate.setCellValueFactory( new PropertyValueFactory<>("RegDate"));
		
		// 테이블뷰에 데이터 추가하기
		ObservableList<Board> list = FXCollections.observableArrayList(
            boardList
		);
		
		boardTableView.setItems(list);

        
    }

    public static void loginMessage(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginMessage'");
    }
    
}
