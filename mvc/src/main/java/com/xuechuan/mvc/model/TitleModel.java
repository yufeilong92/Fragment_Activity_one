package com.xuechuan.mvc.model;

import com.xuechuan.mvc.View.RequestStringResultView;
import com.xuechuan.mvc.contract.TitleContract;

import java.util.ArrayList;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc.model
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 15:18
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class TitleModel implements TitleContract.Model {

    @Override
    public void loadtTitles(RequestStringResultView listener) {
        ArrayList<String> mTitles = new ArrayList<>();
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        mTitles.add("小明");
        listener.onComplete(mTitles);
    }


}
