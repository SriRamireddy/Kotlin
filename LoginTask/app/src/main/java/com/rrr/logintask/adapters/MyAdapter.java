package com.rrr.logintask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.rrr.logintask.MainActivity;
import com.rrr.logintask.ProfileFragment;
import com.rrr.logintask.R;
import com.rrr.logintask.model.Datum;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewInfo> {


    private List<Datum> data;
    private MainActivity ct;
    public MyAdapter(MainActivity activity, List<Datum> data)
    {
        this.data=data;
        this.ct=activity;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewInfo(layoutInflater.inflate(R.layout.design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewInfo holder, int position) {

        final Datum datum=data.get(position);
        holder.mailText.setText(datum.getEmail());
        holder.itemView.setOnClickListener(v -> {
            FragmentTransaction transaction1 = ct.getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.page2,new ProfileFragment(datum));
            transaction1.commit();
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewInfo extends RecyclerView.ViewHolder
    {

        TextView mailText;
        public MyViewInfo(@NonNull View itemView) {
            super(itemView);
            mailText=itemView.findViewById(R.id.textView);
        }
    }
}
