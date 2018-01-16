package com.example.xyy.emoji2string;

/**
 * Created by xyy on 2017/12/21.
 * * Class Note:
 * 1 完成presenter的实现。这里面主要是Model层和View层的交互和操作。
 * 2 presenter里面还有个 OnButtonFinishedListener，
 * 其在 Presenter层实现，给Model层回调，更改 View层的状态，
 * 确保 Model层不直接操作 View层。如果没有这一接口在 EmPresenterImpl实现的话，
 * EmPresenterImpl只有 View和 Model的引用那么 Model怎么把结果告诉 View呢？
 */

public class EmPresenterImpl implements EmPresenter, OnButtonFinishedListener {
    private EmView emView;
    private EmModel emModel;

    public EmPresenterImpl(EmView emView) {
        this.emView = emView;
        this.emModel = new EmModelImpl();
    }

    @Override
    public void validateCredentials1(String s1) {
        if (emView != null) {
            emView.showProgressDialog();
        }
        emModel.emojiToString(s1, this);
    }

    @Override
    public void validateCredentials2(String s2) {
        if (emView != null) {
            emView.showProgressDialog();
        }
        emModel.stringToEmoji(s2, this);
    }

    @Override
    public void onDestroy() {
        emView = null;
    }

    @Override
    public void onEditTextNull() {
        if (emView != null) {
            emView.setEditTextNull();
            emView.hideProgressDialog();
        }
    }

    @Override
    public void onTextViewNull() {
        if (emView != null) {
            emView.setTextViewNull();
            emView.hideProgressDialog();
        }
    }

    @Override
    public void onEmojiToStringSuccess(String test1) {
        if (emView != null) {
            emView.setTestToString(test1);
            emView.hideProgressDialog();
        }
    }

    @Override
    public void onStringToEmojiSuccess(String test2) {
        if (emView != null) {
            emView.setTestToEmoji(test2);
            emView.hideProgressDialog();
        }
    }


}
