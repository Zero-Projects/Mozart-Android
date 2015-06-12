package com.mozart.mozart_android;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ExplorarObras extends Fragment {
    Typeface RobotoThin,RobotoRegular,RobotoMedium,RobotoLight,iconFonts,enterFont;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_explorar_obras, container, false);

        cargarFuentes();

        return view;
    }

    public void cargarFuentes(){
        RobotoLight = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Light.ttf");
        RobotoRegular = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Regular.ttf");
        RobotoMedium = Typeface.createFromAsset(getActivity().getAssets(),"Roboto-Medium.ttf");

    }
}
