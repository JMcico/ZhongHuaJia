package com.example.zhonghuajia;

/**
 * Created by peple on 2018/8/12.
 */

public class Plant {

    private String name;

    private int imageId;

    public Plant(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
