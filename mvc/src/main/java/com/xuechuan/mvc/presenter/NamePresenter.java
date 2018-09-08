package com.xuechuan.mvc.presenter;

import com.xuechuan.mvc.View.RequestStringResultView;
import com.xuechuan.mvc.contract.NameContract;
import com.xuechuan.mvc.model.NameModel;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc.presenter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 17:48
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class NamePresenter<T extends NameContract.View> extends BasePresenter<T> implements NameContract.Presenter {
    private NameModel model = new NameModel();

    public void fetch() {
        if (mViewRef.get() != null) {
            mViewRef.get().showLoading();
        }
        if (model != null) {
            model.loadName(new RequestStringResultView() {
                @Override
                public void onComplete(List<String> lists) {
                    mViewRef.get().onCompleta(lists);
                }
            });
        }
    }

    ;
}
