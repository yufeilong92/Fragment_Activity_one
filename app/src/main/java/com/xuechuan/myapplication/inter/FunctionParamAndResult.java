package com.xuechuan.myapplication.inter;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.inter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/6 15:29
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public abstract class FunctionParamAndResult<Paramt, Result> extends Function {

    public FunctionParamAndResult(String functionName) {
        super(functionName);
    }

    public abstract Result funciton(Paramt paramt);
}
