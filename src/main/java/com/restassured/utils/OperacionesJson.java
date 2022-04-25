package com.restassured.utils;

import com.google.gson.Gson;

import java.util.Map;

public class OperacionesJson {

    public static Object convertirAJson(Object objeto) {
        final Gson gson = new Gson();
        return gson.toJson(objeto);
    }

    public static Map convertirAMap(String objeto) {
        final Gson gson = new Gson();
        return gson.fromJson(objeto, Map.class);
    }
}