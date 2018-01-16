package com.example.xyy.emoji2string;

/**
 * Created by xyy on 2017/12/21.
 * Class Note:主页面的 Presenter的接口，实现类为 EmPresenterImpl，完成主页面的验证，以及销毁当前view
 */

public interface EmPresenter {
    void validateCredentials1(String s1);

    void validateCredentials2(String s2);

    void onDestroy();
}
