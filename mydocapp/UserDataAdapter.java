package com.example.mydocapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserDataAdapter extends
        RecyclerView.Adapter<UserDataAdapter.ViewHolder>{
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView UserID;
        TextView Password;
        public ViewHolder(View itemView){
            super(itemView);
            UserID = itemView.findViewById(R.id.DoctorName);
            Password = itemView.findViewById(R.id.Time);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    clickListener.onItemLongClick(
                            getAdapterPosition(),view
                    );
                    return true;
                }
            });
        }
    }
    private static ClickListener clickListener;
    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemLongClick(int position,View view);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.
                inflate(R.layout.activity_user_data_adapter,parent,
                        false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,
                                 int position) {
        UserData c = Singleton.getInstance().getUsers().get(position);
        holder.UserID.setText(c.userid);
        holder.Password.setText(c.password);
    }

    @Override
    public int getItemCount() {
        return Singleton.getInstance().getUsers().size();
    }
}