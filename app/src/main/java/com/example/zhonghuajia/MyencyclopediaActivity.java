package com.example.zhonghuajia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyencyclopediaActivity extends BaseActivity {

    public static void actionStart(Context context, String data3, String data4){
        Intent intent = new Intent(context, MyencyclopediaActivity.class);
        intent.putExtra("param3", data3);
        intent.putExtra("param4", data4);
        context.startActivity(intent);
    }

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon",
    "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
    "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
    "pineapple", "Strawberry", "Cherry", "Mango" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myencyclopedia);

        ActionBar actionbar = getSupportActionBar(); //屏蔽标题
        if(actionbar != null){
            actionbar.hide();
        }

        initPlants(); //初始化植物
        PlantAdapter adapter = new PlantAdapter(MyencyclopediaActivity.this, R.layout.plant_item, plantList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Plant plant = plantList.get(position);
                Toast.makeText(MyencyclopediaActivity.this, plant.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyencyclopediaActivity.this,
                android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/
    }

    private List<Plant> plantList = new ArrayList<>();

    private void initPlants(){
        for(int i = 0; i < 2; i++){
            Plant apple = new Plant("Apple 苹果(píng guǒ)", R.drawable.apple_pic);
            plantList.add(apple);
            Plant banana = new Plant("Banana 香蕉(xiāng jiāo)", R.drawable.banana_pic);
            plantList.add(banana);
            Plant orange = new Plant("Orange 橘子(jú zi)", R.drawable.orange_pic);
            plantList.add(orange);
            Plant watermelon = new Plant("Watermelon 西瓜(xī guā)", R.drawable.watermelon_pic);
            plantList.add(watermelon);
            Plant pear = new Plant("Pear 梨(lí)", R.drawable.pear_pic);
            plantList.add(pear);
            Plant grape = new Plant("Grape 葡萄(pú tao)", R.drawable.grape_pic);
            plantList.add(grape);
            Plant pineapple = new Plant("Pineapple 菠萝(bō luó)", R.drawable.pineapple_pic);
            plantList.add(pineapple);
            Plant strawberry = new Plant("Strawberry 草莓(cǎo méi)", R.drawable.strawberry_pic);
            plantList.add(strawberry);
            Plant cherry = new Plant("Cheery 樱桃(yīng táo)", R.drawable.cheery_pic);
            plantList.add(cherry);
            Plant mango = new Plant("Mango 芒果(máng guǒ)", R.drawable.mango_pic);
            plantList.add(mango);
        }
    }
}
