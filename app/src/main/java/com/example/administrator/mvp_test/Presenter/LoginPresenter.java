package com.example.administrator.mvp_test.Presenter;

import android.os.Looper;
import android.widget.Toast;

import com.example.administrator.mvp_test.Model.IModel;
import com.example.administrator.mvp_test.Model.user;
import com.example.administrator.mvp_test.View.IView;

import java.util.logging.Handler;

/**
 * Created by Administrator on 2017/7/21.
 */

public class LoginPresenter implements IPresneter{
    IModel iModel;
    IView iView;
    Handler handler;

    public  LoginPresenter(IView iView){
        this.iView=iView;
        initUser();
//        handler = new Handler(Looper.getMainLooper());
//        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
//        Toast.makeText(this,"用户名："+name,Toast.LENGTH_SHORT).show();
        boolean isLoginSuccess=true;
        final int code=iModel.checkUserValidity(name,password);
        if (0!=code)
            isLoginSuccess=false;
        final boolean result=isLoginSuccess;
        iView.onLoginResult(result,code);


    }

//    @Override
//    public void setProgressBarVisibility(int visibility) {
//            iView.onSetProgressBarVisibility(visibility);
//    }
    public void initUser(){
        iView= (IView) new user("MVP","MVP");
    }
}
