package com.example.xyy.emoji2string;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Class Note:MVP模式中View层对应一个activity，这里是主页面的activity
 *
 * Demo的代码流程：
 *
 * 一. Activity做了一些 UI初始化的东西并需要实例化对应 EmPresenter的引用和实现 EmView的接口，
 * 监听界面动作，转字符串按钮按下后即接收到 OnButtonFinishedListener的事件，
 * 在onClick里接收到即通过 EmPresenter的引用把它交给EmPresenter处理。
 *
 * 二. EmPresenter接收到了转字符串的逻辑就知道要转字符串了，然后EmPresenter显示进度条并且把逻辑交给我们的Model去处理，
 * 也就是这里面的EmModel，（EmModel的实现类EmModelImpl），同时会把OnButtonFinishedListener也就是EmPresenter
 * 自身传递给我们的Model（EmModel）。
 *
 * 三. EmModel处理完逻辑之后，结果通过 OnButtonFinishedListener回调通知EmPresenter，
 * EmPresenter再把结果返回给view层的Activity，最后activity显示结果~
 *
 * 搞定~0.0
 *
 */

public class MainActivity extends AppCompatActivity implements EmView, View.OnClickListener {

    private EditText editText;
    private TextView textView;
    private Button button1;
    private Button button2;
    private boolean progressShow;
    private EmPresenter emPresenter;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.ed);
        textView = findViewById(R.id.tv);
        button1 = findViewById(R.id.bt1);
        button2 = findViewById(R.id.bt2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        emPresenter = new EmPresenterImpl(this);

    }

    @Override
    public void showProgressDialog() {
        progressShow = true;
        pd = new ProgressDialog(this);
        pd.setCanceledOnTouchOutside(false);
        pd.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                progressShow = false;
            }
        });
        pd.setMessage("生成中......");
        pd.show();
    }

    @Override
    public void hideProgressDialog() {
        pd.dismiss();
    }

    @Override
    public void setEditTextNull() {
        Toast.makeText(this, "请输入表情", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTextViewNull() {
        Toast.makeText(this, "请输入表情", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTestToString(String test1) {
        textView.setText(test1);
    }

    @Override
    public void setTestToEmoji(String test2) {
        textView.setText(test2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                emPresenter.validateCredentials1(editText.getText().toString());
                break;
            case R.id.bt2:
                emPresenter.validateCredentials2(textView.getText().toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        emPresenter.onDestroy();
        super.onDestroy();
    }
}
