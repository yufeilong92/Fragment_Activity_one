package com.xuechuan.mvc.presenter;

import com.xuechuan.mvc.contract.TitleContract;

import java.lang.ref.WeakReference;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc.presenter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 16:26
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class BasePresenter<T > {
    protected WeakReference<T> mViewRef;
    public void attch(T v) {
        mViewRef = new WeakReference<>(v);
    }

    public void detectAttch() {
        mViewRef.clear();
    }


}
