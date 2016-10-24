package com.ldrong.notepad.ui.notelist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.notepad.R;
import com.ldrong.notepad.TimeLineAdapter;
import com.ldrong.notepad.base.AppContext;
import com.ldrong.notepad.conn.MessageEvent;
import com.ldrong.notepad.db.Note;
import com.ldrong.notepad.db.NoteDao;
import com.ldrong.notepad.ui.notelist.db.NoteHelper;
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
                if (note.getIsCompComplete()) {
                    sex.add(new RadioListDialogItem("2", "Forget"));

                } else {

                    sex.add(new RadioListDialogItem("3", "Complete"));
                }
                RadioCustomListDialog dialog = new RadioCustomListDialog(getContext(), sex, new DialogRadioCallback() {

                    public void DialogRadioClick(RadioListDialogItem item) {
                        LogUtils.e(item.getText());
                        if ("Delete".equals(item.getText())) {
                            //删除.更新adapter
                            NoteHelper.deleteNote(note);
                            adapter.delete(position);
                        } else if ("Forget".equals(item.getText())) {
                            note.setIsCompComplete(false);
                            NoteHelper.forget(note);
                            adapter.update(position, false);
                        } else if ("Complete".equals(item.getText())) {
                            note.setIsCompComplete(true);
                            NoteHelper.forget(note);
                            adapter.update(position, true);
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


}
