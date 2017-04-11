package com.ldrong.notepad.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ldrong.notepad.R;
import com.ldrong.notepad.widget.RadioListDialogItem;
import com.ldrong.notepad.widget.timeline.DialogRadioCallback;

import java.util.List;

public class RadioCustomListDialog extends Dialog {
	private static List<RadioListDialogItem> itemList;
	private Context mContext;
	private DialogRadioCallback callback;

	public RadioCustomListDialog(Context context, List<RadioListDialogItem> itemList,
								 DialogRadioCallback dialogRadioCallback) {
		super(context, R.style.Theme_Transparent);
		this.itemList = itemList;
		this.mContext = context;
		this.callback = dialogRadioCallback;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.listdialog_layout);
		ListView lv_dialog = (ListView) findViewById(R.id.lv_dialog);
		listdialogAdapter adapter = new listdialogAdapter(mContext, itemList);
		lv_dialog.setAdapter(adapter);
		lv_dialog.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
									long arg3) {
				callback.DialogRadioClick(itemList.get(position));
				RadioCustomListDialog.this.dismiss();
			}
		});
		super.onCreate(savedInstanceState);
	}
	private class listdialogAdapter extends BaseAdapter {
		private Context mContext;
		private List<RadioListDialogItem> list;
		private LayoutInflater mInflater;
		
		
		public listdialogAdapter(Context mContext, List<RadioListDialogItem> list) {
			super();
			this.mContext = mContext;
			this.list = list;
			this.mInflater = LayoutInflater.from(mContext);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int position, View convertview, ViewGroup parent) {
			viewHolder viewHolder = null;
			if (convertview ==null) {
				viewHolder = new viewHolder();
				convertview = mInflater.inflate(R.layout.item_listdialog,null);
				viewHolder.tv = (TextView) convertview.findViewById(R.id.tv_listdialog);
				convertview.setTag(viewHolder);
			}else{
				viewHolder = (viewHolder) convertview.getTag();
			}
			viewHolder.tv.setText(list.get(position).getText());
			
			return convertview;
		}
		private class viewHolder{
			private TextView tv;
		}
		
	}
	
	
}
