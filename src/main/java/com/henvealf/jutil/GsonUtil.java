package com.henvealf.jutil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * Created by Henvealf on 2017/6/15.
 * http://git.oschina.net/henvealf
 */
public class GsonUtil {

    private static Gson gson = new Gson();

    // 将 json 转为 map。
    public static Map<String,String> jsonToMap(String json) {
        Map<String, String> map = gson.fromJson(json,new TypeToken<Map<String, String>>() {}.getType());
        return map;
    }
}
