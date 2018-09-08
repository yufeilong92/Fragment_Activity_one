package com.xuechuan.mvc.presenter;

import com.xuechuan.mvc.View.RequestStringResultView;
import com.xuechuan.mvc.contract.TitleContract;

import com.xuechuan.mvc.model.TitleModel;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc.presenter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 15:18
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class TitlePresenter<T extends TitleContract.View> extends BasePresenter<T> {

    TitleContract.Model mTitleMonte = new TitleModel();


    public void fetch() {
        if (mViewRef.get() != null) {
            mViewRef.get().showLoading();
        }
        if (mTitleMonte != null) {
            mTitleMonte.loadtTitles(new RequestStringResultView() {
                @Override
                public void onComplete(List<String> lists) {
                    mViewRef.get().showTitles(lists);
                }
            });
        }

    }

}
