package com.example.Controller;

import java.io.IOException;


import com.example.App;
import com.example.DTO.Board;
import com.example.Service.BoardService;
import com.example.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DeleteController {

    BoardServiceImpl boardServicelmpl = new BoardServiceImpl();

    @FXML
    private TextField tNo;

    @FXML
    private TextArea tContent;

    @FXML
    private TextField tTitle;

    @FXML
    private TextField tWriter;


  private BoardService boardService = new BoardServiceImpl();

   // 목록
   @FXML
   void moveToList(ActionEvent event) throws IOException {
       App.setRoot("board/list");
   }

  
  
  @FXML
  void delete(ActionEvent event) throws IOException {
      
      Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("게시글 삭제");
        alert.setHeaderText(null);
        alert.setContentText("게시글을 삭제하시겠습니까?");
        
        // 예 또는 아니오 버튼을 생성하고 다이얼로그에 추가
        ButtonType buttonTypeYes = new ButtonType("예");
        ButtonType buttonTypeNo = new ButtonType("아니오");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        
        
		alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buttonTypeYes) {
                int result = 0;
                int Delete = Integer.parseInt(tNo.getText());
                result = boardServicelmpl.delete(Delete);
                if (result > 0) {
                    Alert successAlert = new Alert(AlertType.INFORMATION);
                    successAlert.setTitle("알림");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("게시글이 삭제되었습니다.");
                    successAlert.showAndWait();
                } else {
                    Alert failAlert = new Alert(AlertType.ERROR);
                    failAlert.setTitle("알림");
                    failAlert.setHeaderText(null);
                    failAlert.setContentText("게시글 삭제에 실패하였습니다.");
                    failAlert.showAndWait();
                }
            }
            else if (buttonType == buttonTypeNo) {
                // 아무것도 하지 않음
            }
        });
        App.setRoot("board/list");
    }
    // 글 수정 처리
    @FXML
    public void update(ActionEvent event) throws IOException {
        Board board = new Board(tTitle.getText(), tWriter.getText(), tContent.getText());
        board.setNo(Integer.parseInt(tNo.getText()));
        int result = boardService.update(board);
        if (result > 0) {
            // 수정 성공 시 다이얼로그 표시
            showAlert("알림", "글 수정 처리 성공!", Alert.AlertType.INFORMATION);
        } else {
            // 수정 실패 시 다이얼로그 표시
            showAlert("알림", "글 수정 처리 실패!", Alert.AlertType.WARNING);
        }
        App.setRoot("board/list");
    }
    
    // 다이얼로그 표시 메서드
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}