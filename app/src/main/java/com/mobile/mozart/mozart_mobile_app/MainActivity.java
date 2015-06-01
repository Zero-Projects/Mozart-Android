package com.mobile.mozart.mozart_mobile_app;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        //Declara los textView
        TextView txtIniciarSesion = (TextView) findViewById(R.id.txtIniciaSesion);
        TextView iconEntrar = (TextView) findViewById(R.id.iconEntrar);
        TextView txtCuentaVinculada = (TextView)findViewById(R.id.txtCuentaVinculada);
        TextView txtRegistrate = (TextView)findViewById(R.id.txtRegistrate);
        TextView txtProblemas = (TextView)findViewById(R.id.txtProblemas);

        TextView iconFacebook = (TextView) findViewById(R.id.iconFacebook);
        TextView iconTwitter = (TextView) findViewById(R.id.iconTwitter);
        TextView iconGooglePlus = (TextView) findViewById(R.id.iconGooglePlus);
        TextView iconEmail = (TextView) findViewById(R.id.iconEmail);
        TextView iconPassword = (TextView) findViewById(R.id.iconPassword);
        TextView iconRegistrate = (TextView) findViewById(R.id.iconRegistrate);
        TextView iconProblemas = (TextView) findViewById(R.id.iconProblemas);


        //Declara los EditText
        EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        EditText txtPassword = (EditText)findViewById(R.id.txtPassword);

        //Carga las fuentes
        Typeface RobotoThin = Typeface.createFromAsset(this.getAssets(),"Roboto-Thin.ttf");
        Typeface RobotoRegular = Typeface.createFromAsset(this.getAssets(),"Roboto-Regular.ttf");
        Typeface RobotoMedium = Typeface.createFromAsset(this.getAssets(),"Roboto-Medium.ttf");
        Typeface RobotoLight = Typeface.createFromAsset(this.getAssets(),"Roboto-Light.ttf");

        //Carga los icon-fonts
        Typeface iconFonts = Typeface.createFromAsset(this.getAssets(),"fontawesome-webfont.ttf");

        //Asigna los estilos de fuentes
        txtIniciarSesion.setTypeface(RobotoLight);
        iconEntrar.setTypeface(RobotoLight);
        txtCuentaVinculada.setTypeface(RobotoLight);
        txtEmail.setTypeface(RobotoLight);
        txtPassword.setTypeface(RobotoLight);
        txtRegistrate.setTypeface(RobotoLight);
        txtProblemas.setTypeface(RobotoLight);

        //Asigna los iconfonts
        iconFacebook.setTypeface(iconFonts);
        iconTwitter.setTypeface(iconFonts);
        iconGooglePlus.setTypeface(iconFonts);
        iconEntrar.setTypeface(iconFonts);
        iconEmail.setTypeface(iconFonts);
        iconPassword.setTypeface(iconFonts);
        iconRegistrate.setTypeface(iconFonts);
        iconProblemas.setTypeface(iconFonts);


        //Asigna el logo a imgZero
        final ImageView logoZero = (ImageView) findViewById(R.id.imgZero);
        logoZero.setImageResource(R.drawable.zero_logo_white);
        logoZero.setScaleY(1);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
