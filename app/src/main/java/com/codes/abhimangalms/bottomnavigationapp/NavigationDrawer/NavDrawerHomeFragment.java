package com.codes.abhimangalms.bottomnavigationapp.NavigationDrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codes.abhimangalms.bottomnavigationapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavDrawerHomeFragment extends Fragment {


    public NavDrawerHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_drawer_home, container, false);
    }

}
