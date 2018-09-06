package com.xuechuan.myapplication.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.xuechuan.myapplication.MainActivity;
import com.xuechuan.myapplication.inter.FunctionsManger;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.fragment
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/6 16:35
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class BaseFragment extends Fragment {
    protected FunctionsManger mFuntionManger;
    private MainActivity mBaseActivity;

    public void setmFuntionManger(FunctionsManger mFuntionManger) {
        this.mFuntionManger = mFuntionManger;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mBaseActivity = (MainActivity) context;
            mBaseActivity.setFunctontForFragment(getTag());
        }

    }
}
