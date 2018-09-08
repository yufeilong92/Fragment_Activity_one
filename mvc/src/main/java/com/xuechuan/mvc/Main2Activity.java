package com.xuechuan.mvc;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.xuechuan.mvc.Adapter.TitleAdapter;
import com.xuechuan.mvc.contract.NameContract;
import com.xuechuan.mvc.presenter.NamePresenter;

import java.util.List;

public class Main2Activity extends BaseActivity<NameContract.View, NamePresenter<NameContract.View>> implements NameContract.View {

    private ListView mLvSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        titlePresenter.fetch();
    }

    @Override
    protected NamePresenter<NameContract.View> createPresenter() {
        return new NamePresenter<>();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onCompleta(List<String> list) {
        TitleAdapter adapter = new TitleAdapter(this, list);
        mLvSite.setAdapter(adapter);
    }

    private void initView() {
        mLvSite = (ListView) findViewById(R.id.lv_site);
    }
}
