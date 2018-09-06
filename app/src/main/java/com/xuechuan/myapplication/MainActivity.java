package com.xuechuan.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xuechuan.myapplication.fragment.BaseFragment;
import com.xuechuan.myapplication.fragment.BlankFragment;
import com.xuechuan.myapplication.fragment.BlankFragment2;
import com.xuechuan.myapplication.fragment.BlankFragment3;
import com.xuechuan.myapplication.fragment.BlankFragment4;
import com.xuechuan.myapplication.inter.FunctionNoParamNoResult;
import com.xuechuan.myapplication.inter.FunctionParamAndResult;
import com.xuechuan.myapplication.inter.FunctionWithParamOnly;
import com.xuechuan.myapplication.inter.FunctionWithResultOnly;
import com.xuechuan.myapplication.inter.FunctionsManger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "===========";
    private ViewPager mViewpager;
    private List<String> mtitles;
    private List<Fragment> mFragments;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addTitle();
        initData();

    }

    private void addTitle() {
        if (mtitles == null) {
            mtitles = new ArrayList<>();
        }
        mtitles.add("无参结");
        mtitles.add("仅有参");
        mtitles.add("仅有结");
        mtitles.add("都有");
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        mFragments.add(BlankFragment.newInstance("", ""));
        mFragments.add(BlankFragment2.newInstance("", ""));
        mFragments.add(BlankFragment3.newInstance("", ""));
        mFragments.add(BlankFragment4.newInstance("", ""));
    }

    private void initData() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments, mtitles);
        mViewpager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewpager);
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
    }

    public void setFunctontForFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
        FunctionsManger mFuntionManger = FunctionsManger.getInstance();
        fragment.setmFuntionManger(mFuntionManger.addFunction(new FunctionNoParamNoResult(BlankFragment.INTERFACE) {
            @Override
            public void funciton() {
                Toast.makeText(MainActivity.this, "成功调用无参无结果", Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithParamOnly<String>(BlankFragment2.YOUCANWURESULT) {
            @Override
            public void function(String o) {
                Toast.makeText(MainActivity.this, "接受传递的参数" + o, Toast.LENGTH_SHORT).show();
            }
        })
                .addFunction(new FunctionWithResultOnly<String>(BlankFragment3.INTERFACE_RESULT_ONLY) {
                    @Override
                    public String funciton() {
                        return "我测试成功";
                    }
                })
                .addFunction(new FunctionParamAndResult<String, Integer>(BlankFragment4.INTERFACE_PARAMRESUL) {
                    @Override
                    public Integer funciton(String o) {
                        Toast.makeText(MainActivity.this,"有参数有结果"+o,Toast.LENGTH_SHORT).show();
                        return 520;
                    }
                }));
    }


}
