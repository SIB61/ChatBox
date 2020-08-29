package com.sib4u.chatbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sib4u.chatbox.models.UserModel;
import com.sib4u.chatbox.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConAdapter extends RecyclerView.Adapter<ConAdapter.ConViewHolder>
{
private Context ctx;
private List<UserModel> userModels;

    public ConAdapter(Context ctx, List<UserModel> userModels) {
        this.ctx = ctx;
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public ConAdapter.ConViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConViewHolder(LayoutInflater.from(ctx).inflate(R.layout.recyclerview_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ConAdapter.ConViewHolder holder, int position) {
         holder.Name.setText(userModels.get(position).getName());
         holder.imageView.setImageResource(R.drawable.ic_baseline_person_outline_24);

    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class ConViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        CircleImageView imageView;
        public ConViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.photo);
            Name=itemView.findViewById(R.id.Name);
        }
    }

}
