package com.xuechuan.mvc.model;

import com.xuechuan.mvc.View.RequestStringResultView;
import com.xuechuan.mvc.contract.NameContract;

import java.util.ArrayList;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc.model
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 17:48
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class NameModel implements NameContract.Model {
    @Override
    public void loadName(RequestStringResultView requestStringResultView) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        requestStringResultView.onComplete(strings);
    }
}
