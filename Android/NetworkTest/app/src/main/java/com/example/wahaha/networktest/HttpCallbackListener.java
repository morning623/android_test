package com.example.wahaha.networktest;

/**
 * Created by wahaha on 2018/11/8.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
