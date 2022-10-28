package com.example.eindprojectv1;

import com.example.eindprojectv1.Data.Database;
import com.example.eindprojectv1.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class navController implements Initializable {
    @FXML
    Pane layout;

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(name));
        fxmlLoader.setController(controller);
        VBox lendReceivePane = fxmlLoader.load();
        if(layout.getChildren().size() > 0)
            layout.getChildren().remove(0);
        layout.getChildren().add(lendReceivePane);
    }

    public void loadLendingOrReceivingView() throws  IOException{
        loadScene("hello-view.fxml", new HelloController(database, user));
    }

    public void loadTicketView() throws  IOException{
        loadScene("ticket-view.fxml", new TicketController(database, user));
    }
}
