package com.rrr.logintask;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rrr.logintask.adapters.MyAdapter;
import com.rrr.logintask.databinding.FragmentMailsBinding;
import com.rrr.logintask.model.Datum;
import com.rrr.logintask.room.UserViewmodel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MailsFragment extends Fragment {

    FragmentMailsBinding mailsBinding;
    MyAdapter userAdapter;
    private UserViewmodel userViewModel;
    private MainActivity activity;
    RecyclerView recyclerView;
    public MailsFragment(MainActivity mainActivity) {
        // Required empty public constructor
        this.activity=mainActivity;
    }
    public MailsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mailsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_mails, container, false);
        View v = mailsBinding.getRoot();
        recyclerView = mailsBinding.recycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        userViewModel.getmAllWords().observe(getViewLifecycleOwner(), new Observer<List<Datum>>() {
            @Override
            public void onChanged(List<Datum> data) {
                if(data.size()>0) {
                    userAdapter = new MyAdapter(activity, data);
                    recyclerView.setAdapter(userAdapter);
                }
            }
        });

        return v;
    }
}
