package com.example.zhonghuajia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MynotesActivity extends BaseActivity {

    public static void actionStart(Context context, String data1, String data2){
        //该活动需要接受数据的标准启动写法
        Intent intent = new Intent(context, MynotesActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mynotes);

        ActionBar actionbar = getSupportActionBar(); //屏蔽标题
        if(actionbar != null){
            actionbar.hide();
        }

        Button heavenback = (Button) findViewById(R.id.title_back);
        heavenback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        Button heavensave = (Button) findViewById(R.id.title_edit);
        heavensave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MynotesActivity.this, "保存成功啦！", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
