package com.example.xyy.emoji2string;

/**
 * Created by xyy on 2017/12/21.
 * Class Note:模拟主页面的操作的接口，实现类为EmModelImpl.相当于MVP模式中的Model层
 */

public interface EmModel {
    void emojiToString(String s1, OnButtonFinishedListener listener);

    void stringToEmoji(String s2, OnButtonFinishedListener listener);
}
