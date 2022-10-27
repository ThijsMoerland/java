package com.example.eindprojectv1.Data;

import com.example.eindprojectv1.Model.Item;
import com.example.eindprojectv1.Model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Database {
    //list of users that are allowed to log in
    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    //constructor initializing 2 users in the list
    public Database() {
        users.add(new User(users.size()+1,"Thijs","Moerland","ThijsMoerland", "Dolfijn1"));
        users.add(new User(users.size()+1,"Grote","Eikel","Docent", "Test12345"));

        items.add(new Item(items.size()+1,"book"));
        items.add(new Item(items.size()+1,"mug"));
        items.add(new Item(items.size()+1,"pen"));
    }

    //getter
    public List<User> getUsers() {
        return users;
    }

    public User getUserByID(int ID){
        for (User user : users){
            if (user.getIdentifier() == ID)
                return user;
        }
        return null;
    }

    public List<Item> getItems() { return  items;}

    public Item getItemByID(int ID){
        for (Item item : items){
            if (item.getCode() == ID)
                return item;
        }
        return null;
    }

}
