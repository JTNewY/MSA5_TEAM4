package com.example.Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneUtil {

    private static SceneUtil instance;

    Stage stage;
    Scene scene;
    Parent root;
    FXMLLoader loader;
    
    private SceneUtil() {
        
    }

    public static SceneUtil getInstance() {
        if(instance == null) {
            instance = new SceneUtil();
        }
        return instance;
    }

    
}
