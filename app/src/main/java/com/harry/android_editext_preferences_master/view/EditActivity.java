package com.harry.android_editext_preferences_master.view;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.harry.android_editext_preferences_master.R;
import com.harry.android_editext_preferences_master.base.BaseActivity;
import com.harry.android_editext_preferences_master.util.LogUtils;

import static android.text.TextUtils.isEmpty;

/**
 * @author Martin-harry
 * @date 2021/8/4
 * @address
 * @Desc EditActivity输入框处理
 */
public class EditActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back;
    private TextView name;
    private TextView age;

    @Override
    protected void initView() {
        back = findViewById(R.id.back);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);

        back.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences settings = getSharedPreferences("Selector", 0);
        Boolean user_first = settings.getBoolean("FIRST", true);
        if (user_first) {
            settings.edit().putBoolean("FIRST", false).commit();
            LogUtils.e("进入activity", "第一次进入");
        } else {
            readParameter();
            LogUtils.e("进入activity", "第二次进入");
        }

        LogUtils.e("进入activity", "onStart---");
    }

    @Override
    protected void onStop() {
        super.onStop();

        //存储edit数据
        SharedPreferences sharedPreferences = getSharedPreferences("editMath",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name.getText().toString());
        editor.putString("age", age.getText().toString());
        editor.commit();

        LogUtils.e("进入activity", "onStop---");
    }

    @Override
    protected void initData() {

    }


    private void readParameter() {
        //获取edit数据
        SharedPreferences sharedPreferences = getSharedPreferences("editMath",
                MODE_PRIVATE);
        String nameEdit = sharedPreferences.getString("name", "");
        String ageEdit = sharedPreferences.getString("age", "");
        LogUtils.e("edit存储的数据信息：", nameEdit + "---" + ageEdit);
        if (!isEmpty(nameEdit) || !isEmpty(ageEdit)) {
            name.setText(nameEdit);
            age.setText(ageEdit);
        }
    }

    @Override
    protected int createViews() {
        return R.layout.activity_edit;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
