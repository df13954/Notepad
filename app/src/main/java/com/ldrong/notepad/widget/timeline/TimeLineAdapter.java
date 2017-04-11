package com.ldrong.notepad.widget.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldrong.notepad.R;
import com.ldrong.notepad.db.Note;

import java.util.List;


public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {
    private List<Note> mDataSet;

    public TimeLineAdapter(List<Note> models) {
        mDataSet = models;
    }

    public void delete(int position) {
        this.mDataSet.remove(position);
        notifyDataSetChanged();
    }

    public void update(int position,boolean u) {
        this.mDataSet.get(position).setIsCompComplete(u);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        final int size = mDataSet.size() - 1;
        if (size == 0)
            return ItemType.ATOM;
        else if (position == 0)
            return ItemType.START;
        else if (position == size)
            return ItemType.END;
        else return ItemType.NORMAL;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_time_line, viewGroup, false);
        return new TimeLineViewHolder(v, viewType,onRecyclerViewListener);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder timeLineViewHolder, int i) {
        timeLineViewHolder.setData(mDataSet.get(i));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static interface OnRecyclerViewListener {

        boolean onItemLongClick(int position);

    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    public void uadataAll(List<Note> list) {
        this.mDataSet = list;
        notifyDataSetChanged();
    }

}
