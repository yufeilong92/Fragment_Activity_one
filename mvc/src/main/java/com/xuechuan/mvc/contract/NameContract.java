package com.xuechuan.mvc.contract;

import com.xuechuan.mvc.View.RequestStringResultView;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc.contract
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 17:48
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public interface NameContract {
    interface Model {
        public void loadName(RequestStringResultView requestStringResultView);
    }

    interface View {
        public void showLoading();

        public void onCompleta(List<String> list);
    }

    interface Presenter {

    }
}
