package com.example.administrator.mvp_test.Model;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface IModel {
    String getName();
    String getPassword();
    int checkUserValidity(String name,String password);
}
