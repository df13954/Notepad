package com.ldrong.notepad.utils.greendaoutils.timeline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ldrong.notepad.R;
import com.ldrong.notepad.db.Note;
import com.ldrong.notepad.widget.TimeLineMarker;


/**
 * Created by qiujuer
 * on 15/8/23.
 */
public class TimeLineViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    private LinearLayout root_View;
    private TimeLineMarker mMarker;
    private TextView mName;
    private Context context;
    private TimeLineAdapter.OnRecyclerViewListener onRecyclerViewListener;

    public TimeLineViewHolder(View itemView, int type, TimeLineAdapter.OnRecyclerViewListener onRecyclerViewListener) {
        super(itemView);
        this.context = itemView.getContext();
        this.onRecyclerViewListener = onRecyclerViewListener;
        mName = (TextView) itemView.findViewById(R.id.item_time_line_txt);
        root_View = (LinearLayout) itemView.findViewById(R.id.root_View);

        mMarker = (TimeLineMarker) itemView.findViewById(R.id.item_time_line_mark);
        if (type == ItemType.ATOM) {
            mMarker.setBeginLine(null);
            mMarker.setEndLine(null);
        } else if (type == ItemType.START) {
            mMarker.setBeginLine(null);
        } else if (type == ItemType.END) {
            mMarker.setEndLine(null);
        }

        root_View.setOnLongClickListener(this);
    }

    public void setData(Note data) {
        if (data.getIsCompComplete()) {
            mMarker.setMarkerDrawable(context.getResources().getDrawable(R.drawable.comp));
        } else {
            mMarker.setMarkerDrawable(context.getResources().getDrawable(R.drawable.default1));

        }

        mName.setText(data.getTime() + " :" + data.getTitle());
    }

    @Override
    public boolean onLongClick(View view) {
        if (null != onRecyclerViewListener) {
            onRecyclerViewListener.onItemLongClick(getAdapterPosition());
        }

        return false;
    }
}
