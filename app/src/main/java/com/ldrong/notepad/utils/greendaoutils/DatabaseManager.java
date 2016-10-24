package com.ldrong.notepad.utils.greendaoutils;

import android.content.Context;

import com.ldrong.notepad.db.DaoSession;

/**
 * @author ldr
 *         created at 2016/10/20 11:28
 * @Description: 类的描述 -greendao 接口 处理数据库打开，调用，连接
 */
public interface DatabaseManager {

    /**
     * 获取数据库连接
     */
    void startup(Context mContext);

    /**
     * 关闭数据库
     */
    void shutdown();

    /**
     * 检查数据库状态是否可用
     *
     * @return
     */
    boolean checkDBStatus();

    /**
     * 获取greenDAO DAO管理类
     *
     * @return
     */
    DaoSession getDaoSession();

}
