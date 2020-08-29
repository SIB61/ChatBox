package com.sib4u.chatbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sib4u.chatbox.R;

import java.util.List;

public class chatOptionAdapter extends RecyclerView.Adapter<chatOptionAdapter.chatOptionViewHolder> {
      private Context ctx;
   private Listener listener;
    public chatOptionAdapter( Context ctx,Listener listener) {
       // this.friendModels = friendModels;
        this.ctx = ctx;
        this.listener=listener;
    }

    @NonNull
    @Override
    public chatOptionAdapter.chatOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.chatoptions_layout,parent,false);
        return new chatOptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatOptionAdapter.chatOptionViewHolder holder, int position) {
         holder.imageView.setImageResource(R.drawable.ic_baseline_person_outline_24);
         holder.name.setText("chatBox");
         holder.lastMsg.setText("welcome to chatbox");
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class chatOptionViewHolder extends RecyclerView.ViewHolder {
        private  ImageView imageView;
        private TextView name,lastMsg;
        public chatOptionViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.chatOptionPhotoID);
            name=itemView.findViewById(R.id.chatOptionNameId);
            lastMsg=itemView.findViewById(R.id.chatOptionLastMsgID);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.clickListener(getAdapterPosition());
                }
            });
        }
    }
  public   interface Listener{
       void clickListener(int position);
    }
}
