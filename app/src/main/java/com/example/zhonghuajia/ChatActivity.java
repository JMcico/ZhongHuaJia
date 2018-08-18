package com.example.zhonghuajia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends BaseActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initMsgs();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    //有新消息时刷新RecyclerView中的显示
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //将RecyclerView定位到最后一行
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    //清空输入框中的内容
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsgs(){
        Msg msg1 = new Msg("Hi", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("你好", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("我刚刚学会使用盆栽助手", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        Msg msg4 = new Msg("我也是呢", Msg.TYPE_SENT);
        msgList.add(msg4);
        Msg msg5 = new Msg("你养的是什么植物啊", Msg.TYPE_RECEIVED);
        msgList.add(msg5);
        Msg msg6 = new Msg("是小草莓，你呢", Msg.TYPE_SENT);
        msgList.add(msg6);
        Msg msg7 = new Msg("哈哈，我也是呢", Msg.TYPE_RECEIVED);
        msgList.add(msg7);
    }
}

