package com.harry.android_editext_preferences_master.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.harry.android_editext_preferences_master.R;
import com.harry.android_editext_preferences_master.base.BaseActivity;

/**
 * @author Martin-harry 
 * @date 2021/8/4
 * @address
 * @Desc MainActivity
 */
public class MainActivity extends BaseActivity{

    private Button bt;

    @Override
    protected void initView() {
        bt = findViewById(R.id.bt);
    }

    @Override
    protected void initData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EditActivity.class));
            }
        });
    }

    @Override
    protected int createViews() {
        return R.layout.activity_main;
    }
}
