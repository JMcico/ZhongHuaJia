package com.example.zhonghuajia;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyfriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfriends);

        //屏蔽标题
        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.hide();
        }

        //启动去聊天
        Button buttontochat = (Button) findViewById(R.id.chat_with_friends_button);
        buttontochat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MyfriendsActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
