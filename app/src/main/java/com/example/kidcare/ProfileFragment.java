package com.example.kidcare;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment implements View.OnClickListener {




    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_profile,container,false);

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn =(Button) getActivity().findViewById(R.id.button);
        btn.setOnClickListener((View.OnClickListener)this);

    }

    @Override
    public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(getActivity(), StartActivity.class);
        startActivity(i);

    }
}