package com.ldrong.notepad.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;

/**
 * @author ldr
 *         created at 2016/10/19 10:59
 * @Description: 类的描述 -appbaseac
 * 目前正在完善base的
 */
public class BaseActivity extends FragmentActivity {
    protected String TAG = this.getClass().getCanonicalName();
    protected BaseActivity mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        //当打开某个ac的时候，可以打印ac的类名，快速定位到改界面
        Log.e("TAG", this.getClass().toString());
    }


    /**
     * 得到自定义的Dialog
     *
     * @param context
     * @param msg
     * @return
     */
    public void showToast(Context context, String msg, int duration) {
        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }


    @Override
    public Resources getResources() {
        //重写这个方法，当手机系统，改变字体大小的时候，保持当前app的字体不被改变。
        //因为很多布局，会因为字体过大，而变形。目前微信，qq，天猫淘宝，都做了相应的处理，大部分app么有注意到这个地方
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;

    }


    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);//某些sdk，可以做界面打开统计
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }


    /**
     * 普通启动Activity
     *
     * @param clazz
     */
    public void startInt(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


    /**
     * startActivity then finish
     * 启动并且销毁自己
     *
     * @param clazz
     */
    public void startIntent(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * @param clazz
     * @param requestCode
     */
    public void startIntent(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * @param clazz
     * @param bundle
     */
    public void startIntent(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//		manager.removeActivity(this);
    }

    public void showToastMsg(String msg) {
        LogUtils.e(msg);
        Toast.makeText(mContext, "" + msg, Toast.LENGTH_SHORT).show();
    }

}
