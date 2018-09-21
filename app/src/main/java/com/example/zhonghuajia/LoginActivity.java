package com.example.zhonghuajia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;

    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        ActionBar actionbar = getSupportActionBar(); //屏蔽标题
        if(actionbar != null){
            actionbar.hide();
        }

        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remamber_pass);
        login = (Button) findViewById(R.id.login_button);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if(isRemember){
            //将账号和密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //默认账号为zhonghuajia密码为123456
                if(account.equals("zhonghuajia") && password.equals("123456")){
                    editor = pref.edit();
                    if(rememberPass.isChecked()){//检查复选框是否被选中
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    }
                    else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,myEyes.class );
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
