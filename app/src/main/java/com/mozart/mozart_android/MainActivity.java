package com.mozart.mozart_android;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    TextView iconEntrar,txtCuentaVinculada,textViewRegistrate,textViewProblemas,iconFacebook,
            iconTwitter,iconGooglePlus,iconEmail,iconPassword,iconRegistrate,iconProblemas;
    EditText editTextEmail, editTextPassword;
    Typeface RobotoThin,RobotoRegular,RobotoMedium,RobotoLight,iconFonts,enterFont;
    ImageButton buttonProblemas, buttonEntrar;
    ImageView logoZero;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarFuentes();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cargarFuentes(){
//        iconEntrar = (TextView) findViewById(R.id.iconEntrar);
        txtCuentaVinculada = (TextView)findViewById(R.id.txtCuentaVinculada);
        textViewRegistrate = (TextView)findViewById(R.id.txtRegistrate);
        textViewProblemas = (TextView)findViewById(R.id.txtProblemas);

        iconFacebook = (TextView) findViewById(R.id.iconFacebook);
        iconTwitter = (TextView) findViewById(R.id.iconTwitter);
        iconGooglePlus = (TextView) findViewById(R.id.iconGooglePlus);
        iconEmail = (TextView) findViewById(R.id.iconEmail);
        iconPassword = (TextView) findViewById(R.id.iconPassword);
        iconRegistrate = (TextView) findViewById(R.id.iconRegistrate);
//        iconProblemas = (TextView) findViewById(R.id.iconProblemas);

        editTextEmail = (EditText)findViewById(R.id.txtEmail);
        editTextPassword = (EditText)findViewById(R.id.txtPassword);

        buttonProblemas = (ImageButton) findViewById(R.id.imageButtonProblemas);
        buttonEntrar = (ImageButton) findViewById(R.id.imageButtonEntrar);

        //Carga las fuentes
//        RobotoThin = Typeface.createFromAsset(this.getAssets(),"Roboto-Thin.ttf");
//        RobotoRegular = Typeface.createFromAsset(this.getAssets(),"Roboto-Regular.ttf");
//        RobotoMedium = Typeface.createFromAsset(this.getAssets(),"Roboto-Medium.ttf");
        RobotoLight = Typeface.createFromAsset(this.getAssets(),"Roboto-Light.ttf");

        //Carga los icon-fonts
        iconFonts = Typeface.createFromAsset(this.getAssets(), "fontawesome-webfont.ttf");
        enterFont = Typeface.createFromAsset(this.getAssets(), "icomoon.ttf");

        //Asigna los estilos de fuentes
//        iconEntrar.setTypeface(RobotoLight);
        txtCuentaVinculada.setTypeface(RobotoLight);
        editTextEmail.setTypeface(RobotoLight);
        editTextPassword.setTypeface(RobotoLight);
        textViewRegistrate.setTypeface(RobotoLight);
        textViewProblemas.setTypeface(RobotoLight);

        //Asigna los iconfonts
        iconFacebook.setTypeface(iconFonts);
        iconTwitter.setTypeface(iconFonts);
        iconGooglePlus.setTypeface(iconFonts);
//        iconEntrar.setTypeface(enterFont);
        iconEmail.setTypeface(iconFonts);
        iconPassword.setTypeface(iconFonts);
        iconRegistrate.setTypeface(iconFonts);
//        iconProblemas.setTypeface(iconFonts);


//        //Asigna el logo a imgZero
//        logoZero = (ImageView) findViewById(R.id.imgZero);
//        logoZero.setImageResource(R.drawable.zero_logo_white);
//        logoZero.setScaleY(1);
    }
}
