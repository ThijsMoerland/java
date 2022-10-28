package com.example.eindprojectv1;

import com.example.eindprojectv1.Data.Database;
import com.example.eindprojectv1.Model.User;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Database db = new Database();
    //gets the users from the database in a list
    private ObservableList<User> users = FXCollections.observableList(db.getUsers());

    @FXML
    Button btnLogin;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label loginLabel;

    //validation for the password has to be atleast 8 characters and need to have at least 1 number and letter other wise the login button stays unclickkable
    public void onPasswordTextChanged(StringProperty observable, String oldValue, String newValue){
        if(newValue.length() < 8)
            btnLogin.setDisable(true);
        else if (newValue.matches(".*[0-9]*.") && newValue.matches(".*[a-z-A-Z]*.")) {
            btnLogin.setDisable(false);
        }
    }

    //checks if the username and password matches to a username and password in the database
    public void checkUser(ActionEvent event) throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();

        for (User user : users){
            if (username.toString().equals(user.getUsername().toString()) && password.toString().equals(user.getPassword().toString())) {
                loadMainWindow(user);
                return;
            }
            // if nothing matches an error messages pops up
            loginLabel.setText("Username and/or password are incorrect please try again");
        }
    }

    // after a succesfull login the main window is loaded in a new scene and displayed in the same stage
    private void loadMainWindow(User user) throws IOException {

        Stage Stage = (Stage)btnLogin.getScene().getWindow();
        Stage.setTitle("Main Window");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nav-view.fxml"));
        navController navController = new navController(db, user);
        fxmlLoader.setController(navController);

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Stage.setScene(scene);
    }
}