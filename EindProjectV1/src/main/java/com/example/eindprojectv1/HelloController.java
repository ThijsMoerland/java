package com.example.eindprojectv1;

import com.example.eindprojectv1.Data.Database;
import com.example.eindprojectv1.Model.Item;
import com.example.eindprojectv1.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HelloController {
    private User user;
    public HelloController(Database database, User user) {
        this.db = database;
        this.user = user;
    }
    private Database db;

    @FXML
    Label welcomeLabel;

    @FXML
    TextField receiveItemCode;

    @FXML
    TextField lendItemCode;

    @FXML
    TextField memberID;

    @FXML
    Label lendMessageLabel;

    @FXML
    Label receiveMessageLabel;



    public void lendItem(){
        int itemCode = Integer.parseInt(lendItemCode.getText());
        int memberCode = Integer.parseInt(memberID.getText());

        Item item;

        if(db.getItemByID(itemCode) != null && db.getUserByID(memberCode) != null){
            item = db.getItemByID(itemCode);

            if(item.getAvailable()){
                item.setAvailable(false);
                item.setLendDate(LocalDateTime.now());
                item.setMemberIdentifier(memberCode);
                lendMessageLabel.setText("successfully lended item");
            }
            else
                lendMessageLabel.setText("item not available");
        }
        else
            lendMessageLabel.setText("item or member cannot be found");
    }

    public void receiveItem(){
        int itemCode = Integer.parseInt(receiveItemCode.getText());

        Item item;

        if(db.getItemByID(itemCode) != null){
            item = db.getItemByID(itemCode);

            if(item.getAvailable() == false){
                int daysLended = (int)Duration.between(item.getLendDate(), LocalDateTime.now()).toDays();
                if (daysLended > 21) {
                    item.setAvailable(true);
                    item.setLendDate(null);
                    receiveMessageLabel.setText("this item was "+(daysLended-21)+" days to late");
                }
                else
                    receiveMessageLabel.setText("successfully received item");
            }
            else
                receiveMessageLabel.setText("this item has not been lended");
        }
        else
            receiveMessageLabel.setText("this item does not exist");
    }
    @FXML
    protected void initialize(){
        welcomeLabel.setText("Welcome "+user.getFirstname()+ " "+user.getLastName());
    }


}