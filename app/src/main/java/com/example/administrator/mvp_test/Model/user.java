package com.example.administrator.mvp_test.Model;

/**
 * Created by Administrator on 2017/7/21.
 */

public class user implements IModel{
    private String name;
    private String password;

    public user(String name ,String password){
        this.name=name;
        this.password=password;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public int checkUserValidity(String name, String password) {
         if (!name.equals(this.name) || !password.equals(this.password))
           return 0;
        else
            return 1;
    }
}
