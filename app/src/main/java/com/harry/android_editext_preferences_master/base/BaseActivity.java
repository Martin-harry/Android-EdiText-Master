package com.harry.android_editext_preferences_master.base;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Martin-harry
 * @date 2021/7/13
 * @address
 * @Desc activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(createViews());//初始化视图
        initView();//初始化控件
        initData();//初始化数据
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int createViews();

}

