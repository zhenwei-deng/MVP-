package com.example.hiot_cloud.test.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_cloud.MainActivity;
import com.example.hiot_cloud.R;
import com.example.hiot_cloud.base.BaseActivity;
import com.example.hiot_cloud.test.mvptest.model.User;


//创建Activity类继承BasePresenter
//明确视图层和主持者层类型
//生成主持者层类变量并创建
//实现createPresenter方法
//实现视图层方法
public class TestMVPActivity extends BaseActivity<TestView, TestPresenter> implements TestView{

    //创建抽象方法，首先要定义一个私有的变量
    private TestPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        presenter = new TestPresenter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);

        final EditText etUserName = findViewById(R.id.et_user_name);
        final EditText etPassword = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        final User user = new User();
        //局部的presenter为空，这边要注释掉，否则presenter为null
        //final TestPresenter presenter = new TestPresenter();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mvc 做法，在这里做身份校验
                user.setUserName(etUserName.getText().toString());
                user.setPassword(etPassword.getText().toString());
                presenter.login(user);
//                login(user);
            }
        });
    }

    @Override
    public TestPresenter createPresenter() {
        return presenter;
    }


    //实现createPresenter方法,实现创建抽象方法


    @Override
    public void showMessage(String msg) {
        Toast.makeText(
                this, msg, Toast.LENGTH_SHORT).show();
    }


//                private void login(User user) {
//                if("zengqiongmei".equals(user.getUserName())&&"123".equals(user.getPassword())){
//                    Toast.makeText(TestMVPActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(TestMVPActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
//                }
//            }
}
