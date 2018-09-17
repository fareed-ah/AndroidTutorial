package com.mobile.android.myalbum.ui.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mobile.android.myalbum.BaseDaggerFragment;
import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.database.UserEntity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class UserFragment extends BaseDaggerFragment implements UserContract.View {

    @BindView(R.id.fragmentRecyclerView)
    RecyclerView userRecyclerView;

    @Inject
    UserContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        requireActivity().setTitle("Users");
        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userRecyclerView = view.findViewById(R.id.fragmentRecyclerView);
        presenter.getUsers();
    }

    @Override
    public void displayUsers(List<UserEntity> users) {
        userRecyclerView.setAdapter(new UserAdapter(users));
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}
