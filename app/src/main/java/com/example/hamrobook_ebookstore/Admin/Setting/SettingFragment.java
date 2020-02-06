package com.example.hamrobook_ebookstore.Admin.Setting;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.MainActivity;
import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.UserApi;
import com.example.hamrobook_ebookstore.model.User;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    TextView username,mobilenumber;
    RelativeLayout relativelayout,relativeLayoutProfile;
    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_setting, container, false);
        relativelayout=root.findViewById(R.id.relativelayout);
        relativeLayoutProfile=root.findViewById(R.id.relativeLayoutProfile);
        username=root.findViewById(R.id.username);
        mobilenumber=root.findViewById(R.id.tvMobile);
        relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear().apply();
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        final Call<User> userCall = usersAPI.getUserDetails(Url.token);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    username.setText(response.body().getUsername());
                    mobilenumber.setText(response.body().getMobileNumber());
                    return;
                }
                else {
                    Toast.makeText(getActivity(), "Error ", Toast.LENGTH_SHORT).show();
                }
//                String username=response.body().getUsername();
//                String mobilenumber=response.body().getMobileNumber();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        relativeLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return root;
    }
}
