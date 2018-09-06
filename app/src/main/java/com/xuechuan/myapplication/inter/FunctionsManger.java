package com.xuechuan.myapplication.inter;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.inter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/6 15:37
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class FunctionsManger {
    private static FunctionsManger _instance;

    private FunctionsManger() {
        mFunctionNoParamNoReuslt = new HashMap<>();
        mFunctionParamAndReuslt = new HashMap<>();
        mFunctionWithParamOnly = new HashMap<>();
        mFunctionWithReusltOnly = new HashMap<>();
    }

    public static FunctionsManger getInstance() {
        if (_instance == null) {
            _instance = new FunctionsManger();
        }
        return _instance;
    }

    private HashMap<String, FunctionNoParamNoResult> mFunctionNoParamNoReuslt;
    private HashMap<String, FunctionParamAndResult> mFunctionParamAndReuslt;
    private HashMap<String, FunctionWithParamOnly> mFunctionWithParamOnly;
    private HashMap<String, FunctionWithResultOnly> mFunctionWithReusltOnly;

    public FunctionsManger addFunction(FunctionNoParamNoResult function) {
        mFunctionNoParamNoReuslt.put(function.mFunctionName, function);
        return this;
    }

    public void invokeFunction(String functionName) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        if (mFunctionNoParamNoReuslt != null) {
            FunctionNoParamNoResult f = mFunctionNoParamNoReuslt.get(functionName);
            if (f != null) {
                f.funciton();
            }
            if (f == null)
                try {
                    throw new FunctionException("Has not this funciton:" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
        }

    }

    public FunctionsManger addFunction(FunctionWithParamOnly function) {
        mFunctionWithParamOnly.put(function.mFunctionName, function);
        return this;
    }

    public <Paramt> void invokeFunction(String functionName, Paramt paramt) {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        if (mFunctionWithParamOnly != null) {
            FunctionWithParamOnly f = mFunctionWithParamOnly.get(functionName);
            if (f != null) {
                f.function(paramt);
            }
            if (f == null)
                try {
                    throw new FunctionException("Has not this funciton:" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
        }

    }

    public FunctionsManger addFunction(FunctionWithResultOnly function) {
        mFunctionWithReusltOnly.put(function.mFunctionName, function);
        return this;
    }

    public <Result> Result invokeFunction(String functionName, Class<Result> c) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        if (mFunctionWithReusltOnly != null) {
            FunctionWithResultOnly f = mFunctionWithReusltOnly.get(functionName);
            if (f != null) {
                if (c != null) {
                    return c.cast(f.funciton());
                } else {
                    return (Result) f.funciton();
                }
            }
            if (f == null)
                try {
                    throw new FunctionException("Has not this funciton:" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
        }
        return null;

    }

    public FunctionsManger addFunction(FunctionParamAndResult function) {
        mFunctionParamAndReuslt.put(function.mFunctionName, function);
        return this;
    }

    public <Paramt, Result> Result invokeFunction(String functionName, Paramt paramt, Class<Result> c) {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        if (mFunctionParamAndReuslt != null) {
            FunctionParamAndResult f = mFunctionParamAndReuslt.get(functionName);
            if (f != null) {
                if (c != null) {
                    return c.cast(f.funciton(paramt));
                } else {
                    return (Result) f.funciton(paramt);
                }
            }
            if (f == null)
                try {
                    throw new FunctionException("Has not this funciton:" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
        }
        return null;

    }
}
