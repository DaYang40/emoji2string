package com.example.xyy.emoji2string;


import android.os.Handler;
import android.text.TextUtils;

import com.example.xyy.emoji2string.util.EmojiUtil;

/**
 * Created by xyy on 2017/12/21.
 * Class Note:延时模拟登陆（2s），如果没输入表情或者没输入字符串则提示请输入，否则操作成功
 */

public class EmModelImpl implements EmModel {
    @Override
    public void emojiToString(final String s1, final OnButtonFinishedListener listener) {

        if (TextUtils.isEmpty(s1)) {

            listener.onEditTextNull();//model层里面回调EditText为空的listener

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    String string = EmojiUtil.getString(s1);
                    listener.onEmojiToStringSuccess(string);//model层里面回调表情转字符串成功的listener

                }
            }, 1000);
        }
    }

    @Override
    public void stringToEmoji(final String s2, final OnButtonFinishedListener listener) {

        if (TextUtils.isEmpty(s2)) {

            listener.onTextViewNull();//model层里面回调TextView为空的listener

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    String emoji = EmojiUtil.getEmoji(this, s2);
                    listener.onStringToEmojiSuccess(emoji);//model层里面回调字符串转表情的listener

                }
            }, 1000);
        }
    }
}
