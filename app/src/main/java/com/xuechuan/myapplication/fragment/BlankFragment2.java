package com.xuechuan.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xuechuan.myapplication.R;


public class BlankFragment2 extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView mTv2;

//    private OnFragmentInteractionListener mListener;

    public BlankFragment2() {
        // Required empty public constructor
    }

    public static String YOUCANWURESULT = BlankFragment2.class.getName() + "YPNR";

    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTv2 = (TextView) view.findViewById(R.id.tv_2);
        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
    }

    public void onButtonPressed() {
        mFuntionManger.invokeFunction(YOUCANWURESULT, "你好吗？");
    }

}
