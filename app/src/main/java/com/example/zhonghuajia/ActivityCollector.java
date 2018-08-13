package com.example.zhonghuajia;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peple on 2018/8/11.
 */

public class ActivityCollector { //活动收集容器，用于彻底退出全部活动
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
