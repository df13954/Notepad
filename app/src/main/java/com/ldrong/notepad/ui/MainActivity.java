package com.ldrong.notepad.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.notepad.R;
import com.ldrong.notepad.base.BaseActivity;
import com.ldrong.notepad.conn.MessageEvent;
import com.ldrong.notepad.db.Note;
import com.ldrong.notepad.ui.notelist.MyFragmentPagerAdapter;
import com.ldrong.notepad.ui.notelist.NoteListFragment;
import com.ldrong.notepad.ui.notelist.db.NoteHelper;
import com.ldrong.notepad.utils.greendaoutils.time.DisplayTimeUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.pager)
    ViewPager pager;
    private ArrayList<Fragment> fragList;
    private MyFragmentPagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        try {
            initView();
            setListener();
        } catch (Exception e) {
            LogUtils.e(TAG, "error: ", e);
        }
    }


    private void setListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "待开发", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                showDialog();
            }
        });
    }

    private void initView() {
        fragList = new ArrayList<Fragment>();
        fragList.add(new NoteListFragment());

        mPageAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragList, new ArrayList<String>());

        pager.setAdapter(mPageAdapter);

    }

    /**
     * 这是兼容的 AlertDialog
     */
    private void showDialog() {
  /*
  这里使用了 android.support.v7.app.AlertDialog.Builder
  可以直接在头部写 import android.support.v7.app.AlertDialog
  那么下面就可以写成 AlertDialog.Builder
  */
        final View view = View.inflate(this, R.layout.input, null);
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("此刻的你正在努力^_^");
//        builder.setMessage("这是 android.support.v7.app.AlertDialog 中的样式");
        builder.setView(view);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                TextInputEditText et = (TextInputEditText) view.findViewById(R.id.ed_content);
                LogUtils.e(et.getText().toString().trim() + "");
                String str = et.getText().toString().trim() + "";
                if (TextUtils.isEmpty(str)) {

                } else {
                    NoteHelper.insertNote(new Note(null, str, "", false, DisplayTimeUtil.saveNoteCreateTime(System.currentTimeMillis()) + ""));
                    //插入完成。通知Fragment更新
                    EventBus.getDefault().post(new MessageEvent.AddNote());
                }

            }
        });
        builder.show();
    }

}
