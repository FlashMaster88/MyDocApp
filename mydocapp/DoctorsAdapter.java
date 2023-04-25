package com.example.mydocapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ViewHolder>{
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView DoctorName;
        TextView DoctorAddress;
        TextView Time;

        public ViewHolder(View itemView){
            super(itemView);
            DoctorName = itemView.findViewById(R.id.DoctorName);
            DoctorAddress = itemView.findViewById(R.id.DoctorAddress);
            Time = itemView.findViewById(R.id.Time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(
                            getAdapterPosition(), view
                    );
                }
            });
        }
    }

    private static ClickListener clickListener;
    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(int position,View view);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.
                inflate(R.layout.activity_doctors_adapter,parent,
                        false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,
                                 int position) {

        DoctorList c = SingletonDoc.getInstance().doctorLists.get(position);
        holder.DoctorName.setText(c.getDoctorname());
        holder.DoctorAddress.setText(c.getdoctoraddress());
        holder.Time.setText(c.gettime());
    }

    @Override
    public int getItemCount() {
        return SingletonDoc.getInstance().doctorLists.size();}
}