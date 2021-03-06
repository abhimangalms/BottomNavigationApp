package com.codes.abhimangalms.bottomnavigationapp.BottomNavigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.codes.abhimangalms.bottomnavigationapp.R;

public class NotificationsFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_notifications, container, false);
        Button notificatinButton  = (Button) view.findViewById(R.id.button_notification);

        notificatinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Notification button pressed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
