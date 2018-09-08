package com.xuechuan.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xuechuan.mvc.Adapter.TitleAdapter;
import com.xuechuan.mvc.contract.TitleContract;
import com.xuechuan.mvc.presenter.TitlePresenter;

import java.util.List;


public class MainActivity extends BaseActivity<TitleContract.View, TitlePresenter<TitleContract.View>> implements TitleContract.View {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        titlePresenter.fetch();
    }

    @Override
    protected TitlePresenter<TitleContract.View> createPresenter() {
        return new TitlePresenter<>();
    }


    @Override
    public void showLoading() {
        Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTitles(List<String> lists) {
        TitleAdapter titleAdapter = new TitleAdapter(this, lists);
        mListView.setAdapter(titleAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
    }


}
