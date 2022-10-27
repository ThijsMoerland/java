package com.example.eindprojectv1;

import com.example.eindprojectv1.Data.Database;
import com.example.eindprojectv1.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.EOFException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class navController implements Initializable {
    @FXML
    VBox layout;

    Database database;
    User user;

    public navController(Database database, User user) {
        this.database = database;
        this.user = user;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadScene("hello-view.fxml", new HelloController(database, user));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadScene(String name, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(name));
        fxmlLoader.setController(controller);
        VBox lendReceivePane = fxmlLoader.load();
        layout.getChildren().add(lendReceivePane);

//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(name));
//            fxmlLoader.setController(controller);
//            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//            if (layout.getChildren().size() > 1)
//                layout.getChildren().remove(1);
//            layout.getChildren().add(scene.getRoot());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
