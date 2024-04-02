package com.example.Controller;

public enum UI {
    
    MAIN("com/example/board/list22.fxml"),
    INSERT("com/example/board/insert.fxml"),
    READ("/com/example/board/Read.fxml");

    private final String path;
    UI(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
}
