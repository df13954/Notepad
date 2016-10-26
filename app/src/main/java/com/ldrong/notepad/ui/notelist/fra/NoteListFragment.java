package com.ldrong.notepad.ui.notelist.fra;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.notepad.R;
import com.ldrong.notepad.base.AppContext;
import com.ldrong.notepad.conn.MessageEvent;
import com.ldrong.notepad.db.Note;
import com.ldrong.notepad.db.NoteDao;
import com.ldrong.notepad.ui.notelist.db.NoteHelper;
import com.ldrong.notepad.utils.greendaoutils.timeline.TimeLineAdapter;
import com.ldrong.notepad.widget.DialogRadioCallback;
import com.ldrong.notepad.widget.RadioCustomListDialog;
import com.ldrong.notepad.widget.RadioListDialogItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteListFragment extends Fragment {


    @BindView(R.id.time_line_recycler)
    RecyclerView timeLineRecycler;
    private TimeLineAdapter adapter;
    private List<Note> models;
    private NoteDao ms;

    public NoteListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        ButterKnife.bind(this, view);
        initView();
        setListener();
        return view;
    }


    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new TimeLineAdapter(getData());

        timeLineRecycler.setLayoutManager(layoutManager);
        timeLineRecycler.setAdapter(adapter);


    }

    private void setListener() {
        adapter.setOnRecyclerViewListener(new TimeLineAdapter.OnRecyclerViewListener() {
            @Override
            public boolean onItemLongClick(final int position) {

                final Note note = models.get(position);


                List<RadioListDialogItem> sex = new ArrayList<RadioListDialogItem>();
                sex.add(new RadioListDialogItem("1", "Delete"));
                sex.add(new RadioListDialogItem("4", "Edit"));
                if (note.getIsCompComplete()) {
                    sex.add(new RadioListDialogItem("2", "Forget"));

                } else {

                    sex.add(new RadioListDialogItem("3", "Complete"));
                }
                RadioCustomListDialog dialog = new RadioCustomListDialog(getContext(), sex, new DialogRadioCallback() {

                    public void DialogRadioClick(RadioListDialogItem item) {
                        LogUtils.e(item.getText());
                        if ("Delete".equals(item.getText())) {
                            showDeleteDialog(note, position);
                        } else if ("Forget".equals(item.getText())) {
                            note.setIsCompComplete(false);
                            NoteHelper.forget(note);
                            adapter.update(position, false);
                        } else if ("Complete".equals(item.getText())) {
                            note.setIsCompComplete(true);
                            NoteHelper.forget(note);
                            adapter.update(position, true);
                        } else if ("Edit".equals(item.getText())) {
                            showDialog(note);
                        }

                    }
                });
                dialog.show();
                return false;
            }
        });
    }

    private List<Note> getData() {
        models = new ArrayList<Note>();
        ms = AppContext.getGreenDaoSessino().getNoteDao();
        models = ms.queryBuilder().list();
        Collections.reverse(models);

        return models;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent.AddNote event) {
        models = ms.queryBuilder().list();
        Collections.reverse(models);

        adapter.uadataAll(models);

    }

    private void showDeleteDialog(final Note note, final int index) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getContext());
        builder.setTitle("Are you sure？");
//        builder.setMessage("这是 android.support.v7.app.AlertDialog 中的样式");
        builder.setNegativeButton("Cancle", null);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //删除.更新adapter
                NoteHelper.deleteNote(note);
                adapter.delete(index);

            }
        });
        builder.show();
    }

    /**
     * 这是兼容的 AlertDialog
     *
     * @param note
     */
    private void showDialog(final Note note) {
  /*
  这里使用了 android.support.v7.app.AlertDialog.Builder
  可以直接在头部写 import android.support.v7.app.AlertDialog
  那么下面就可以写成 AlertDialog.Builder
  */
        final View view = View.inflate(getContext(), R.layout.input, null);
        final TextInputEditText et = (TextInputEditText) view.findViewById(R.id.ed_content);
        et.setText(note.getTitle());
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getContext());
        builder.setTitle("此刻的你正在努力^_^");
//        builder.setMessage("这是 android.support.v7.app.AlertDialog 中的样式");
        builder.setView(view);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                LogUtils.e(et.getText().toString().trim() + "");
                String str = et.getText().toString().trim() + "";
                if (TextUtils.isEmpty(str)) {

                } else {
                    note.setTitle(str);
                    //note.setTime(DisplayTimeUtil.saveNoteCreateTime(System.currentTimeMillis()) + "");
                    LogUtils.e(note);
                    NoteHelper.forget(note);
                    //插入完成。通知Fragment更新
                    EventBus.getDefault().post(new MessageEvent.AddNote());
                }

            }
        });
        builder.show();
    }

}
