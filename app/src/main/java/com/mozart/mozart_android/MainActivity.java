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
    TextView txtCuentaVinculada,textViewRegistrate,textViewProblemas,iconFacebook,
            iconTwitter,iconGooglePlus,iconEmail,iconPassword,iconRegistrate;
    EditText editTextEmail, editTextPassword;
    Typeface RobotoThin,RobotoRegular,RobotoMedium,RobotoLight,iconFonts,enterFont;
    ImageButton buttonProblemas, buttonEntrar;

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
        txtCuentaVinculada = (TextView)findViewById(R.id.txtCuentaVinculada);
        textViewRegistrate = (TextView)findViewById(R.id.txtRegistrate);
        iconFacebook = (TextView) findViewById(R.id.iconFacebook);
        iconTwitter = (TextView) findViewById(R.id.iconTwitter);
        iconGooglePlus = (TextView) findViewById(R.id.iconGooglePlus);
        iconEmail = (TextView) findViewById(R.id.iconEmail);
        iconPassword = (TextView) findViewById(R.id.iconPassword);
        editTextEmail = (EditText)findViewById(R.id.txtEmail);
        editTextPassword = (EditText)findViewById(R.id.txtPassword);

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

        //Asigna los iconfonts
        iconFacebook.setTypeface(iconFonts);
        iconTwitter.setTypeface(iconFonts);
        iconGooglePlus.setTypeface(iconFonts);
        iconEmail.setTypeface(iconFonts);
        iconPassword.setTypeface(iconFonts);
    }
}
