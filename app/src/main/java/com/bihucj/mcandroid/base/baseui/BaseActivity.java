package com.bihucj.mcandroid.base.baseui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bihucj.mcandroid.utils.ViewManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewManager.getInstance().addActivity(this);
        setContentView(getViewId());
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
        initDate();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    protected abstract int getViewId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initDate();
}
