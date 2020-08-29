package com.sib4u.chatbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sib4u.chatbox.models.UserModel;
import com.sib4u.chatbox.R;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder>{
private List<UserModel> userModels;
Context ctx;

    public StoryAdapter(List<UserModel> userModels, Context ctx) {
        this.userModels = userModels;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public StoryAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.story_layout,parent,false);

        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.StoryViewHolder holder, int position) {
         holder.imageView.setImageResource(R.drawable.icon);
    }
    @Override
    public int getItemCount() {
        return 6;
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        private  TextView name;
        private ImageView imageView;
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.storyImageID);
        }
    }
}

