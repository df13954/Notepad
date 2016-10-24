package com.ldrong.notepad.utils.greendaoutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.notepad.db.DaoMaster;
import com.ldrong.notepad.db.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * @author ldr
 *         created at 2016/10/20 11:29
 * @Description: 类的描述 -在Application onCreate方法中创建DatabaseManager，并调用初始化方法
 * startup，在此方法中获取数据库连接并保持，不释放，并通过数据库连接创建greenDao中DAO管理类;
 * 在业务中需要数据库的地方，只需要调用getDaoSession获取DAO管理类调用相应的DAO即可。
 */
public class DatabaseManagerImpl implements DatabaseManager {


    private static final String DBNAME = "note_db";
    private DaoMaster.OpenHelper helper;
    private SQLiteDatabase db;
    private DaoSession daoSession;
    private Context mContext;

    @Override
    public void startup(Context mContext) {
        this.mContext = mContext;

        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
        getOpenHelper();
        db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    @Override
    public void shutdown() {
        if (daoSession != null) {
            daoSession.clear();
        }
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    private void getOpenHelper() {
        if (helper != null) {
            return;
        }
        // TODO: release版本请使用ReleaseOpenHelper
        helper = new DaoMaster.DevOpenHelper(mContext, DBNAME, null);
    }

    @Override
    public boolean checkDBStatus() {
        if (db == null || !db.isOpen()) {
            getOpenHelper();
            db = helper.getWritableDatabase();
        }
        if (db.isOpen()) {
            return true;
        } else {
            LogUtils.e("database open fail.");
            return false;
        }
    }

    @Override
    public synchronized DaoSession getDaoSession() {
        if (!checkDBStatus()) {
            return null;
        }
        if (daoSession == null) {
            DaoMaster daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
