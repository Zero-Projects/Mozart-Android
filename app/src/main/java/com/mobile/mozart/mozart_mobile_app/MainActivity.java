package com.mobile.mozart.mozart_mobile_app;

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
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declara los textView
        TextView txtViewBienvenido = (TextView) findViewById(R.id.textViewBienvenido);
        TextView txtViewIngresa = (TextView) findViewById(R.id.textViewIngresa);
        TextView txtViewFacebook = (TextView) findViewById(R.id.textViewFacebook);
        TextView txtViewTwitter = (TextView) findViewById(R.id.textViewTwitter);
        TextView txtViewGooglePlus = (TextView) findViewById(R.id.textViewGooglePlus);

        //Carga las fuentes
        Typeface RobotoThin = Typeface.createFromAsset(this.getAssets(),"Roboto-Thin.ttf");
        Typeface RobotoRegular = Typeface.createFromAsset(this.getAssets(),"Roboto-Regular.ttf");
        Typeface RobotoMedium = Typeface.createFromAsset(this.getAssets(),"Roboto-Medium.ttf");
        Typeface RobotoLight = Typeface.createFromAsset(this.getAssets(),"Roboto-Light.ttf");

        //Carga los icon-fonts
        Typeface iconFonts = Typeface.createFromAsset(this.getAssets(),"iconFonts.ttf");

        //Asigna los estilos de fuentes
        txtViewBienvenido.setTypeface(RobotoRegular);
        txtViewIngresa.setTypeface(RobotoLight);

        //Asigna los iconfonts
        txtViewFacebook.setTypeface(iconFonts);
        txtViewTwitter.setTypeface(iconFonts);
        txtViewGooglePlus.setTypeface(iconFonts);



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
