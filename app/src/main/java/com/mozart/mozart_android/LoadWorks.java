package com.mozart.mozart_android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class LoadWorks extends Fragment {
    AlertDialog levelDialog;
    Bitmap bitmapImage;
    Button buttonSubirObra,buttonSeleccionarArchivo;
    EditText editTextTitulo, editTextDescripcion,editTextPath;
    ImageView imageViewObra;
    Spinner spinnerCategorias;
    String categoria;
    TextView textViewTitulo, textViewDescripcion, textViewCategoria;
    Typeface RobotoThin, RobotoRegular, RobotoMedium, RobotoLight, iconFonts, enterFont;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_load_works, container, false);
        cargarFuentes();
        //Carga elementos del spinner
        setSpinnerContent(view);

        eventosBotones();


        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
            {
                if (resultCode == Activity.RESULT_OK)
                {
                    Uri photoUri = data.getData();
                    if (photoUri != null)
                    {
                        try {
                            String[] filePathColumn = {MediaStore.Images.Media.DATA};

                            Cursor cursor = getActivity().getContentResolver().query(photoUri, filePathColumn, null, null, null);
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                            String filePath = cursor.getString(columnIndex);
                            cursor.close();
                            bitmapImage = BitmapFactory.decodeFile(filePath);
                            ImageView img = (ImageView) view.findViewById(R.id.imageViewObra);
                            img.setImageBitmap(bitmapImage);
                            img.setVisibility(View.VISIBLE);
                            editTextPath.setText(filePath);
                        }catch(Exception e)
                        {}
                    }
                }// resultCode
            }// case 1
        }// switch, request code
    }

    public void cargarFuentes() {
        textViewTitulo = (TextView) view.findViewById(R.id.TextViewTitulo);
        textViewDescripcion = (TextView) view.findViewById(R.id.TextViewDescripcion);
        textViewCategoria = (TextView) view.findViewById(R.id.TextViewCategoria);

        editTextTitulo = (EditText) view.findViewById(R.id.EditTextTitulo);
        editTextDescripcion = (EditText) view.findViewById(R.id.EditTextDescripcion);
        editTextPath = (EditText) view.findViewById(R.id.EditTextPath);

        buttonSubirObra = (Button) view.findViewById(R.id.buttonSubirObra);
        buttonSeleccionarArchivo = (Button) view.findViewById(R.id.buttonSeleccionarArchivo);

        RobotoLight = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Light.ttf");
        RobotoRegular = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");
        RobotoMedium = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Medium.ttf");

        textViewTitulo.setTypeface(RobotoRegular);
        textViewDescripcion.setTypeface(RobotoRegular);
        textViewCategoria.setTypeface(RobotoRegular);
        editTextTitulo.setTypeface(RobotoMedium);
        editTextDescripcion.setTypeface(RobotoMedium);
        buttonSubirObra.setTypeface(RobotoRegular);
        buttonSeleccionarArchivo.setTypeface(RobotoRegular);

    }
    private void setSpinnerContent(View view){
        spinnerCategorias = (Spinner) view.findViewById(R.id.spinnerCategoria);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity() ,R.array.categorias,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(adapter);
        spinnerCategorias.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id) {
                categoria = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void eventosBotones() {
        buttonSeleccionarArchivo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Imágenes", " Música"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Selecciona el tipo de archivo");
                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0://Imágenes
                                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                                photoPickerIntent.setType("image/*");
                                startActivityForResult(photoPickerIntent, 1);
                                break;
                            case 1://Música

                                break;
                        }
                        levelDialog.dismiss();
                    }
                });
                levelDialog = builder.create();
                levelDialog.show();
            }
        });
    }
}
