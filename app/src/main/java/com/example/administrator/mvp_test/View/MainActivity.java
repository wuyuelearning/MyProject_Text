package com.example.administrator.mvp_test.View;

/**
 * Created by Administrator on 2017/7/21.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvp_test.Presenter.IPresneter;
import com.example.administrator.mvp_test.Presenter.LoginPresenter;
import com.example.administrator.mvp_test.R;
public class MainActivity extends Activity implements  IView, View.OnClickListener{
    private EditText editUserName;
    private EditText editUserPassword;
     private  String userName;
    private String password;
    private Button   bt_Login;
    private Button bt_reset;
    IPresneter iPresneter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editUserName=(EditText)findViewById(R.id.username);
        editUserPassword=(EditText)findViewById(R.id.password);
        bt_Login=(Button)findViewById(R.id.login);
        bt_reset=(Button)findViewById(R.id.reset);

        userName=editUserName.getText().toString();
        password=editUserPassword.getText().toString();
        bt_Login.setOnClickListener(this);
        bt_reset.setOnClickListener(this);

        iPresneter=new LoginPresenter(this);

    }

    @Override
    public void onClearText() {
        editUserName.setText("");
        editUserPassword.setText("");
    }

    @Override
    public void onLoginResult(Boolean reslut, int code) {
        bt_Login.setEnabled(true);
        bt_reset.setEnabled(true);
        if (reslut){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"failed:"+code,Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    public void onSetProgressBarVisibility(int visibility) {
//
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.reset :
                iPresneter.clear();
                break;
            case R.id.login:
                iPresneter.doLogin(userName,password);
                bt_reset.setEnabled(false);
                bt_Login.setEnabled(false);
                iPresneter.doLogin(this.userName,this.password);
                break;
            default:
                Toast.makeText(getApplicationContext(),"请确认用户名或密码",Toast.LENGTH_SHORT).show();
        }

    }
}
