package com.example.eindprojectv1.Model;

import com.example.eindprojectv1.Data.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Item {
    private int itemCode;
    private int memberIdentifier;
    private LocalDateTime lendDate;
    private boolean available;
    private String title;

    public Item(int code ,String title) {
        this.itemCode = code;
        this.memberIdentifier = 0;
        this.available = true;
        this.title = title;
    }

    //getters
    public int getCode() {
        return itemCode;
    }

    public int getMemberIdentifier() {
        return memberIdentifier;
    }

    public LocalDateTime getLendDate() {
        return lendDate;
    }

    public boolean getAvailable() {
        return available;
    }

    public String getTitle() {
        return title;
    }

    public int getItemCode() {
        return itemCode;
    }

    //setters
    public void setCode(int code) {
        this.itemCode = code;
    }

    public void setMemberIdentifier(int memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public void setLendDate(LocalDateTime lendDate) {
        this.lendDate = lendDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }
}
