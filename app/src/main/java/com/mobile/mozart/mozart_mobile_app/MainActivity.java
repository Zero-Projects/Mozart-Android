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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declara los textView
        TextView txtIngresa = (TextView) findViewById(R.id.txtIngresa);
        TextView txtDatosMozart = (TextView) findViewById(R.id.txtDatosMozart);
        TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
        TextView txtPassword = (TextView) findViewById(R.id.txtPassword);
        TextView txtEntra = (TextView) findViewById(R.id.txtEntrar);
        TextView txtFacebook = (TextView) findViewById(R.id.txtFacebook);
        TextView txtTwitter = (TextView) findViewById(R.id.txtTwitter);
        TextView txtGooglePlus = (TextView) findViewById(R.id.txtGooglePlus);

        //Carga las fuentes
        Typeface RobotoThin = Typeface.createFromAsset(this.getAssets(),"Roboto-Thin.ttf");
        Typeface RobotoRegular = Typeface.createFromAsset(this.getAssets(),"Roboto-Regular.ttf");
        Typeface RobotoMedium = Typeface.createFromAsset(this.getAssets(),"Roboto-Medium.ttf");
        Typeface RobotoLight = Typeface.createFromAsset(this.getAssets(),"Roboto-Light.ttf");

        //Carga los icon-fonts
        Typeface iconFonts = Typeface.createFromAsset(this.getAssets(),"fontawesome-webfont.ttf");

        //Asigna los estilos de fuentes
        txtIngresa.setTypeface(RobotoLight);
        txtDatosMozart.setTypeface(RobotoLight);
        txtEmail.setTypeface(RobotoLight);
        txtPassword.setTypeface(RobotoLight);
        txtEntra.setTypeface(RobotoLight);


        //Asigna los iconfonts
        txtFacebook.setTypeface(iconFonts);
        txtTwitter.setTypeface(iconFonts);
        txtGooglePlus.setTypeface(iconFonts);

        //Asigna el logo a imgZero
        final ImageView logoZero = (ImageView) findViewById(R.id.imgZero);
        logoZero.setImageResource(R.drawable.logo);
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
