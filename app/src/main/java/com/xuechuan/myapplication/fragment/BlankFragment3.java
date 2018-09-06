package com.xuechuan.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xuechuan.myapplication.R;


public class BlankFragment3 extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView mTv3;

//    private OnFragmentInteractionListener mListener;

    public BlankFragment3() {
        // Required empty public constructor
    }

    public static final String INTERFACE_RESULT_ONLY = BlankFragment3.class.getName() + "NPWR";

    public static BlankFragment3 newInstance(String param1, String param2) {
        BlankFragment3 fragment = new BlankFragment3();
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
        View view = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTv3 = (TextView) view.findViewById(R.id.tv_3);
        mTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
    }


    public void onButtonPressed() {
        String result = mFuntionManger.invokeFunction(INTERFACE_RESULT_ONLY, String.class);
        Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
    }

}
