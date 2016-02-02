package com.chatapp.fovi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by 21438547 on 27/01/2016.
 */
public class MessageAdapter extends ArrayAdapter<ParseObject>{

    Context mContext;
    List<ParseObject> mMessages;

    public MessageAdapter(Context context, List<ParseObject> messages){
        super(context,R.layout.activity_inbox_fragment, messages);
        mContext = context;
        mMessages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.imageViewItem);
            holder.nameLabel = (TextView) convertView.findViewById(R.id.textViewItem);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ParseObject messages = mMessages.get(position);

        if(messages.getString(ParseConstants.KEY_FILE_TYPE).equals(ParseConstants.TYPE_IMAGE)){
            holder.iconImageView.setImageResource(R.drawable.ic_action_picture);
        }else{
            holder.iconImageView.setImageResource(R.drawable.ic_action_play_over_video);
        }
        holder.nameLabel.setText(messages.getString(ParseConstants.KEY_SENDER_NAME));

        return convertView;
    }

    public static class ViewHolder{
        ImageView iconImageView;
        TextView nameLabel;
    }



}
