package com.xuechuan.mvc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xuechuan.mvc.contract.TitleContract;
import com.xuechuan.mvc.presenter.BasePresenter;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 16:50
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    public T titlePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titlePresenter = createPresenter();
        titlePresenter.attch((V) this);
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        titlePresenter.detectAttch();
    }
}
