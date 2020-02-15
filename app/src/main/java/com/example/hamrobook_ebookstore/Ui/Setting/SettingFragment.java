package com.example.hamrobook_ebookstore.Ui.Setting;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.AboutActivity;
import com.example.hamrobook_ebookstore.MainActivity;
import com.example.hamrobook_ebookstore.MapsActivity;
import com.example.hamrobook_ebookstore.OrderActivity;
import com.example.hamrobook_ebookstore.ProfileActivity;
import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.UserApi;
import com.example.hamrobook_ebookstore.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    TextView username,mobilenumber;
    RelativeLayout relativelayout,relativeLayoutProfile,cart,relativeAbout,relativeAboutUs;
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
        relativeAboutUs=root.findViewById(R.id.relativeAboutUs);
        relativeAbout=root.findViewById(R.id.relativeAbout);
        cart=root.findViewById(R.id.cart);
        username=root.findViewById(R.id.username);
        mobilenumber=root.findViewById(R.id.tvMobile);

        relativeAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });

        relativeAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });

        relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String token = Url.token;
//
//                LogoutBll logoutBll = new LogoutBll();
//                StrictModeClass.StrictMode();
//                if(logoutBll.logout(token)){
//                    startActivity(new Intent(getActivity(), LoginActivity.class));
//                    getActivity().finish();
//                } else {
//                    Toast.makeText(getActivity(), "Error logging out from this device", Toast.LENGTH_SHORT).show();
//                }
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
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        relativeLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
