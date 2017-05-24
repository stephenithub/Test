package com.stephen.test.utils;

//import com.example.stephen.sycamoreyouth_business.base.HttpResponse;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonSyntaxException;
//import com.google.gson.reflect.TypeToken;
//
//public class GsonUtil {
//    private static Gson gson = new Gson();
//
//    public static String toJson(Object object) {
//        return gson.toJson(object);
//    }
//
//    public static <T> T fromJson(String json, Class<T> clazz) {
//        return gson.fromJson(json, clazz);
//    }
//
//    public static <T> T fromJson(JsonElement element, Class<T> clazz) {
//        return gson.fromJson(element, clazz);
//    }
//
//    public static <T> T json2Data(String json, TypeToken<HttpResponse<T>> token) throws JsonSyntaxException {
//        return ((HttpResponse<T>) gson.fromJson(json, token.getType())).getData();
//    }
//
//    public static <T> HttpResponse<T> json2Bean(String json, TypeToken<HttpResponse<T>> token) throws JsonSyntaxException {
//        return (HttpResponse<T>) gson.fromJson(json, token.getType());
//    }
//}

