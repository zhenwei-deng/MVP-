package com.example.hiot_cloud.base;

/**
 * MVP架构Presenter层
 * 设计主持者层模板类
 */

//定义泛型类型V  ，继承自BaseView
// 代码为<V extends BaseView>    泛型V 继承自BaseView
    //extends代表一个不确定的一个类型，后面加上BaseView就是指它是BaseView的子类
public class BasePresenter<V extends BaseView> {
    //定义一个private变量
    //定义的view类，使用的是V的泛型类型
    private V view;


    //定义一个构造函数
    public BasePresenter() {
        this.view = view;
    }



    //定义一个serView方法
    public void setView(V view){
        this.view = view;

    }


    public V getView(){
        return view;
    }
    public  void destroy(){
        if (viewAttached()){
            //判断视图是否为空
            view = null;
        }

    }

    //做一个判断的函数，判断定义的视图是否被绑定的方法view Attached
    public boolean viewAttached(){
        //判断视图是否为空，有绑定则释放它
        return view != null;
    }

}
