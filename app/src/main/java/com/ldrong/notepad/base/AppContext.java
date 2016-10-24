package com.ldrong.notepad.base;

import android.app.Application;

import com.apkfuns.logutils.LogLevel;
import com.apkfuns.logutils.LogUtils;
import com.ldrong.notepad.db.DaoSession;
import com.ldrong.notepad.utils.greendaoutils.DatabaseManagerImpl;



/**
 * Created by ldr on 2016/10/12.
 */

public class AppContext extends Application {
    private static final String TAG = "AppContext";
    private static DatabaseManagerImpl databaseManager;

    @Override
    public void onCreate() {
        super.onCreate();
//        //初始化请求
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
////                .addInterceptor(new LoggerInterceptor("TAG"))
//                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
//                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                //其他配置
//                .build();
//
//        OkHttpUtils.initClient(okHttpClient);

        //日志初始化
        LogUtils.getLogConfig()
                .configAllowLog(true)
                .configTagPrefix("baseApp")
                .configShowBorders(true)
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}")
                .configLevel(LogLevel.TYPE_INFO);
        //初始化数据库，打开数据库
        initGreenDao();
    }

    /**
     * 初始化数据库，打开数据库
     */
    private void initGreenDao() {
        databaseManager = new DatabaseManagerImpl();
        databaseManager.startup(this);
    }

    /**
     * 提供外部使用
     *
     * @return DaoSession
     */
    public static DaoSession getGreenDaoSessino() {
        return databaseManager.getDaoSession();
    }
}
