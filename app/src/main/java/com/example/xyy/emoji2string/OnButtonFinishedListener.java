package com.example.xyy.emoji2string;

/**
 * Created by xyy on 2017/12/21.
 * Class Note:主页面按钮事件监听
 */

public interface OnButtonFinishedListener {
    void onEditTextNull();

    void onTextViewNull();

    void onEmojiToStringSuccess(String test1);

    void onStringToEmojiSuccess(String test2);
}
