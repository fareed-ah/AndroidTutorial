package com.mobile.android.myalbum.ui.user;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.model.user.User;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserFragment extends Fragment implements UserContract.View {

    private UserContract.Presenter presenter;
    private RecyclerView userRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Activity activity = getActivity();
        if(activity != null){
            activity.setTitle("Users");
        }

        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new UserPresenterImpl(this,new NetworkManager(), Schedulers.io(), AndroidSchedulers.mainThread());
        userRecyclerView = view.findViewById(R.id.fragmentRecyclerView);
        presenter.getUsers();
    }

    @Override
    public void displayUsers(List<User> users) {
        userRecyclerView.setAdapter(new UserAdapter(users));
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show();
    }
}
