package com.mozart.mozart_android;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class CargarObras extends Fragment {
    TextView textViewTitulo, textViewDescripcion, textViewCategoria;
    EditText editTextTitulo, editTextDescripcion;
    Typeface RobotoThin, RobotoRegular, RobotoMedium, RobotoLight, iconFonts, enterFont;
    Button buttonSubirObra;
    Spinner spinnerCategorias;
    View view;
    String categoria;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_cargar_obras, container, false);
        cargarFuentes();
        //Carga elementos del spinner
        setSpinnerContent(view);
        return view;
    }

    public void cargarFuentes() {
        textViewTitulo = (TextView) view.findViewById(R.id.TextViewTitulo);
        textViewDescripcion = (TextView) view.findViewById(R.id.TextViewDescripcion);
        textViewCategoria = (TextView) view.findViewById(R.id.TextViewCategoria);

        editTextTitulo = (EditText) view.findViewById(R.id.EditTextTitulo);
        editTextDescripcion = (EditText) view.findViewById(R.id.EditTextDescripcion);

        buttonSubirObra = (Button) view.findViewById(R.id.buttonSubirObra);

        RobotoLight = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Light.ttf");
        RobotoRegular = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
        RobotoMedium = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Medium.ttf");

        textViewTitulo.setTypeface(RobotoRegular);
        textViewDescripcion.setTypeface(RobotoRegular);
        textViewCategoria.setTypeface(RobotoRegular);
        editTextTitulo.setTypeface(RobotoMedium);
        editTextDescripcion.setTypeface(RobotoMedium);
        buttonSubirObra.setTypeface(RobotoRegular);
    }
    private void setSpinnerContent(View view){
        spinnerCategorias = (Spinner) view.findViewById(R.id.spinnerCategoria);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity() ,R.array.categorias,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(adapter);
        spinnerCategorias.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id){
                categoria = parentView.getItemAtPosition(position).toString();
                Toast.makeText(parentView.getContext(), "Has seleccinado " +
                        parentView.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
