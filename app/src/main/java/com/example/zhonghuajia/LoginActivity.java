package com.example.zhonghuajia;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionbar = getSupportActionBar(); //屏蔽标题
        if(actionbar != null){
            actionbar.hide();
        }

        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //默认账号为zhonghuajia密码为123456
                if(account.equals("zhonghuajia") && password.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this, myEyes.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "账号和密码不匹配哦", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
