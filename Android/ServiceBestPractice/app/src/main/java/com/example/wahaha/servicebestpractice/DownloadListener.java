package com.example.wahaha.servicebestpractice;

/**
 * Created by wahaha on 2018/11/13.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
