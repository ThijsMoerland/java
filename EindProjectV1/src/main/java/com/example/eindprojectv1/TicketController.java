package com.example.eindprojectv1;

import com.example.eindprojectv1.Data.Database;
import com.example.eindprojectv1.Model.Item;
import com.example.eindprojectv1.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TicketController implements Initializable {
    private User user;

    public TicketController(Database database, User user) {
        this.database = database;
        this.user = user;
    }
    private Database database;
    private ObservableList<Item> items;
    @FXML
    TableView<Item> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items = FXCollections.observableList(database.getItems());
        table.getItems().setAll(items);
    }
}
