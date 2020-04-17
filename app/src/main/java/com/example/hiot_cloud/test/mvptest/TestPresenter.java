package com.example.hiot_cloud.test.mvptest;

import com.example.hiot_cloud.base.BasePresenter;

import com.example.hiot_cloud.test.mvptest.model.User;


//TestPresenter extends(继承) BasePresenter，同时要指定BasePresenter的泛型
//创建主持者层类继承BasePresenter，明确视图层接口行，实现特性方法
public class TestPresenter extends BasePresenter<TestView> {

    //基类中已经实现了对TestView view变量的定义
    //private TestView view;

    //去掉了构造函数TestView view
    //{ this.view = view;}

    //改成了无参数的构造函数
    public TestPresenter() {

    }


    //public void setView(TestView view){
     //   this.view = view;
    //}
    public void login(User user){
        if("dengzhenwei".equals(user.getUserName())&&"123".equals(user.getPassword())){
            getView().showMessage("登录成功");
        }else{
            getView().showMessage("登录失败");
        }
    }
    //增加一个destroy方法
//    public void destroy(){
//        if(view != null){
//            view = null;
//        }
//
//    }
}
