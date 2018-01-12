package com.example.study.fastjson.JSONPath;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/11.
 */
public class Demo01 {

    public static void main(String [] args){

        Map map1 = new HashMap();
        map1.put("id",1);
        map1.put("name","inner1");

        Map map2 = new HashMap();
        map2.put("id",2);
        map2.put("name","inner2");

        List list = new ArrayList();
        list.add(map1);
        list.add(map2);

        Map map = new HashMap();
        map.put("id",1);
        map.put("name","outer");
        map.put("detail",list);

        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject.toJSONString());

        List<Object> names = (List<Object>) JSONPath.eval(jsonObject, "$..name");

        for (int i = 0; i <names.size() ; i++) {
            System.out.println("name["+i+"]:"+names.get(i));
        }



    }
}
