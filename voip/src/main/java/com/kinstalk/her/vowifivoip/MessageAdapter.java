package com.kinstalk.her.vowifivoip;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.juphoon.rcs.JRMessageConstants;
import com.juphoon.rcs.JRMessageItem;

import java.util.ArrayList;

/**
 * Created by mofei on 2017/12/17.
 */

public class MessageAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<JRMessageItem> mList;

    public MessageAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<JRMessageItem> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        JRMessageItem item = mList.get(i);
        if (item.getMessageType() == JRMessageConstants.Type.LMSG
                || item.getMessageType() == JRMessageConstants.Type.PMSG) {
            TextViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_text_message, viewGroup, false);
                holder = new TextViewHolder();
                holder.time = convertView.findViewById(R.id.text_time);
                holder.content = convertView.findViewById(R.id.text_content);
                holder.state = convertView.findViewById(R.id.text_state);
                convertView.setTag(holder);
            } else {
                holder = (TextViewHolder) convertView.getTag();
            }
            if (item.getDirection() == JRMessageConstants.Direction.SEND) {
                holder.time.setText("发送时间:" + item.getTimeStamp());
            } else {
                holder.time.setText("接收时间:" + item.getTimeStamp());
            }
            holder.content.setText(item.getText());
            holder.state.setText(getStateByItme(item));
        } else if (item.getMessageType() == JRMessageConstants.Type.IMAGE
                || item.getMessageType() == JRMessageConstants.Type.GEO) {
            ImageHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_image_message, viewGroup, false);
                holder = new ImageHolder();
                holder.time = convertView.findViewById(R.id.image_time);
                holder.content = convertView.findViewById(R.id.image_content);
                holder.state = convertView.findViewById(R.id.image_state);
                convertView.setTag(holder);
            } else {
                holder = (ImageHolder) convertView.getTag();
            }
            if (item.getDirection() == JRMessageConstants.Direction.SEND) {
                holder.time.setText("发送时间:" + item.getTimeStamp());
            } else {
                holder.time.setText("接收时间:" + item.getTimeStamp());
            }
            if (item.getMessageType() == JRMessageConstants.Type.GEO) {
                holder.content.setImageResource(R.mipmap.ic_launcher);
            } else {
                holder.content.setImageURI(Uri.parse(item.getFilePath()));
            }
            holder.state.setText(getStateByItme(item));
        }
        return convertView;
    }

    String getStateByItme(JRMessageItem item) {
        if (item.getState() == JRMessageConstants.State.INIT) {
            return "未发送";
        } else if (item.getState() == JRMessageConstants.State.SENDING) {
            return "发送中" + item.getTranferSize() * 100 / item.getFileSize() + "%";
        } else if (item.getState() == JRMessageConstants.State.SEND_OK) {
            return "发送成功";
        } else if (item.getState() == JRMessageConstants.State.SEND_FAILED) {
            return "发送失败";
        } else if (item.getState() == JRMessageConstants.State.RECEIVE_INVITE) {
            return "未接收";
        } else if (item.getState() == JRMessageConstants.State.RECEIVE_FAILED) {
            return "接收失败";
        } else if (item.getState() == JRMessageConstants.State.RECEIVE_OK) {
            return "接收成功";
        } else if (item.getState() == JRMessageConstants.State.RECEIVEING_PAUSE) {
            return "暂停";
        }
        return "";
    }


    class TextViewHolder {
        TextView time;
        TextView content;
        TextView state;
    }

    class ImageHolder {
        TextView time;
        ImageView content;
        TextView state;
    }
}
