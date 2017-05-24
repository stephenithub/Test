//package com.stephen.test.utils;
//
//import android.os.Message;
//
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//
//
///**
// * Created by Stephen on 2017/1/4 16:ic_launcher
// * Email: 895745843@qq.com
// */
//
//public class HttpRequestUtil {
//
//    public static Call post(Map<String, String> params, String requestUrl){
//        LogUtil.E("请求接口为" + requestUrl + "\n" + "请求参数为" + removedUnnecessaryNameValuePairs(params).toString());
//        String requestUrlreal = requestUrl;
//        if (!requestUrl.contains("http")) {
//            requestUrlreal = URL.BASE_URL + requestUrl;
//        }
//        return OkHttpUtils.post(requestUrlreal, params);
//    }
//
//    public static Call post(String requestUrl, GlobalDataCallBack callBack) {
//        return post(null, requestUrl, callBack, true);
//    }
//
//    public static Call post(Map<String, String> params, String requestUrl, GlobalDataCallBack callBack) {
//        return post(params, requestUrl, callBack, true);
//    }
//
//    public static Call post(final Map map, final String requestUrl, GlobalDataCallBack callBack, boolean isShowProgress) {
//        if (isShowProgress && callBack != null) {
//            callBack.onStart();
//        }
//        final BaseHandler handler = new BaseHandler(null, callBack);
////        LogUtil.e("请求接口为" + requestUrl + "\n" + "请求参数为" + list.toString());
//        String requestUrlreal = requestUrl;
//        if (!requestUrl.contains("http")) {
//            requestUrlreal = URL.BASE_URL + requestUrl;
//        }
//        return OkHttpUtils.post(requestUrlreal, map, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Message msg = Message.obtain();
//                msg.what = BaseHandler.CALLBACK_FAILURE;
//                LogUtil.E("请求接口为" + requestUrl + "\n" + "请求失败");
//                handler.sendMessage(msg);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Message msg = Message.obtain();
//                msg.what = BaseHandler.CALLBACK_SUCCESS;
//                msg.obj = response.body().string();
//                LogUtil.E("请求接口为" + requestUrl + "\n" + "请求参数为" + removedUnnecessaryNameValuePairs(map).toString() + "\n" + "返回数据为" + msg.obj);
//                handler.sendMessage(msg);
//            }
//        });
//    }
//
//    /**
//     * 移除不必打印的key-value
//     */
//    private static Map removedUnnecessaryNameValuePairs(Map nameValuePairs){
//        if (nameValuePairs == null) {
//            return new HashMap();
//        }
//        return nameValuePairs;
//    }
//}
