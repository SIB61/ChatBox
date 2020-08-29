package com.sib4u.chatbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sib4u.chatbox.R;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context ctx;
    List<String> msgList;

    public chatAdapter(Context ctx, List<String> msgList) {
        this.ctx = ctx;
        this.msgList = msgList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType==1)
        {
            return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.me,parent,false));
        }
        else {
            return new FriendViewHolder(LayoutInflater.from(ctx).inflate(R.layout.friend,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==1)
        {
           MyViewHolder holder1= (MyViewHolder) holder;
           holder1.msg.setText(msgList.get(position));
           holder1.time.setText("now");
        }
        else {
            FriendViewHolder holder2= (FriendViewHolder) holder;
            holder2.msg.setText(msgList.get(position));
            holder2.time.setText("1 min");
        }
    }

    @Override
    public int getItemViewType(int position) {
        return  position%2==0? 1:0;
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  msg,time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            msg=itemView.findViewById(R.id.msg);
            time=itemView.findViewById(R.id.time);

        }
    }
    class FriendViewHolder extends RecyclerView.ViewHolder{
        TextView  msg,time;
        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            msg=itemView.findViewById(R.id.msg1);
            time=itemView.findViewById(R.id.time1);
        }
    }


}
