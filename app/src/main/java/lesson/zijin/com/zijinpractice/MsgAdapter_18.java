package lesson.zijin.com.zijinpractice;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;
import static android.os.Build.VERSION_CODES.N;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class MsgAdapter_18 extends ArrayAdapter<Msg_18 > {
    private int resourceId;
    public MsgAdapter_18( Context context, int textViewResourceId, List<Msg_18> objects)
    {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Msg_18 msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null)
        {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (msg.getType() == Msg_18.TYPE_RECEIVED)
        {
            // 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            viewHolder.leftLayout.setVisibility(View.VISIBLE);viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        } else if(msg.getType() == Msg_18.TYPE_SENT)
        {
            // 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }
    class ViewHolder
    {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }
}
