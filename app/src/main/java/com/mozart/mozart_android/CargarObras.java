package com.mozart.mozart_android;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CargarObras extends Fragment {
    TextView textViewTitulo, textViewDescripcion, textViewCategoria;
    EditText editTextTitulo, editTextDescripcion, editTextCategoria;
    Typeface RobotoThin, RobotoRegular, RobotoMedium, RobotoLight, iconFonts, enterFont;
    Button buttonSubirObra;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_cargar_obras, container, false);

        cargarFuentes();

        return view;
    }

    public void cargarFuentes() {
        textViewTitulo = (TextView) view.findViewById(R.id.TextViewTitulo);
        textViewDescripcion = (TextView) view.findViewById(R.id.TextViewDescripcion);
        textViewCategoria = (TextView) view.findViewById(R.id.TextViewCategoria);

        editTextTitulo = (EditText) view.findViewById(R.id.EditTextTitulo);
        editTextDescripcion = (EditText) view.findViewById(R.id.EditTextDescripcion);
        editTextCategoria = (EditText) view.findViewById(R.id.EditTextCategoria);

        buttonSubirObra = (Button) view.findViewById(R.id.buttonSubirObra);

        RobotoLight = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Light.ttf");
        RobotoRegular = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
        RobotoMedium = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Medium.ttf");

        textViewTitulo.setTypeface(RobotoRegular);
        textViewDescripcion.setTypeface(RobotoRegular);
        textViewCategoria.setTypeface(RobotoRegular);
        editTextTitulo.setTypeface(RobotoMedium);
        editTextDescripcion.setTypeface(RobotoMedium);
        editTextCategoria.setTypeface(RobotoMedium);
        buttonSubirObra.setTypeface(RobotoRegular);
    }


}
