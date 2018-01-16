package com.example.xyy.emoji2string;

/**
 * Created by xyy on 2017/12/21.
 * Class Note:主页面View的接口，实现类也就是主页面的activity
 */

public interface EmView {
    void showProgressDialog();

    void hideProgressDialog();

    void setEditTextNull();

    void setTextViewNull();

    void setTestToString(String test1);

    void setTestToEmoji(String test2);
}
