package com.xuechuan.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xuechuan.myapplication.R;


public class BlankFragment4 extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String INTERFACE_PARAMRESUL = BlankFragment4.class.getName() + "YPYR";

    private String mParam1;
    private String mParam2;
    private TextView mTv4;


    public BlankFragment4() {
        // Required empty public constructor
    }


    public static BlankFragment4 newInstance(String param1, String param2) {
        BlankFragment4 fragment = new BlankFragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment4, container, false);
        initView(inflate);
        return inflate;
    }

    public void onButtonPressed() {
        Integer integer = mFuntionManger.invokeFunction(INTERFACE_PARAMRESUL,"你好吗？", Integer.class);
        Toast.makeText(getActivity(), "获取的结果" + integer, Toast.LENGTH_SHORT).show();

    }

    private void initView(View inflate) {
        mTv4 = (TextView) inflate.findViewById(R.id.tv_4);
        mTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
    }
}
