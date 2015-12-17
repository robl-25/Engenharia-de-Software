package com.example.jimy.sussa;

/**
 * Created by Jimy on 16/12/15.
 */
public class BDManager {
    public void addUser(User u){
        int id = (int)Math.random()*1000;
        BDUsers.hashUsers.put("o", u);
    }
}
