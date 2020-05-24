package com.rrr.logintask;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rrr.logintask.databinding.FragmentProfileBinding;
import com.rrr.logintask.model.Datum;
import com.rrr.logintask.room.UserViewmodel;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private FragmentProfileBinding profileBinding;
    Datum datum;
    private UserViewmodel UserViewModel;
    private List<Datum> list;

    public ProfileFragment(Datum datum) {
        // Required empty public constructor
        this.datum=datum;
    }
    public ProfileFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false);
        View v = profileBinding.getRoot();
        UserViewModel = new ViewModelProvider(this).get(UserViewmodel.class);
        profileBinding.firstname.setText(datum.getFirstName());
        profileBinding.lastname.setText(datum.getLastName());
        profileBinding.email.setText(datum.getEmail());
        Picasso.get().load(datum.getAvatar()).placeholder(R.drawable.profilepic).into(profileBinding.avatar);

        return v;
    }
}
