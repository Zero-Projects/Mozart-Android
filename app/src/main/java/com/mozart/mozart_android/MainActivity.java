package com.mozart.mozart_android;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    TextView txtCuentaVinculada;
    EditText editTextEmail, editTextPassword;
    Typeface RobotoThin,RobotoRegular,RobotoMedium,RobotoLight,iconFonts,enterFont;
    Button buttonProblemas,buttonEntra;
    ImageButton buttonEntrar,buttonEmail,buttonPassword,ButtonEmail,ButtonPassword;
    String email=null, password=null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asignarFuentes();
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

    public void asignarFuentes(){
        txtCuentaVinculada = (TextView)findViewById(R.id.txtCuentaVinculada);
        editTextEmail = (EditText)findViewById(R.id.txtEmail);
        editTextPassword = (EditText)findViewById(R.id.txtPassword);
        buttonEntra = (Button)findViewById(R.id.buttonEntrar);
        buttonProblemas = (Button)findViewById(R.id.buttonProblemas);
        buttonEmail = (ImageButton)findViewById(R.id.buttonEmail);
        buttonPassword = (ImageButton)findViewById(R.id.buttonPassword);

        //Carga la fuentes
        RobotoLight = Typeface.createFromAsset(this.getAssets(),"Roboto-Light.ttf");
        RobotoRegular = Typeface.createFromAsset(this.getAssets(),"Roboto-Regular.ttf");
        RobotoMedium = Typeface.createFromAsset(this.getAssets(),"Roboto-Medium.ttf");

        //Asigna los estilos de fuentes
        editTextEmail.setTypeface(RobotoMedium);
        editTextPassword.setTypeface(RobotoMedium);
        txtCuentaVinculada.setTypeface(RobotoRegular);
        buttonProblemas.setTypeface(RobotoRegular);
        buttonEntra.setTypeface(RobotoRegular);
    }
    public void onClickEntrar(View view){
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        if(email.equals("mozart")  && password.equals("mozart")){
            Intent intent = new Intent(this, GestorPages.class);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                            "Verifica tus datos", Toast.LENGTH_SHORT);

            toast.show();
            buttonProblemas.setVisibility(View.VISIBLE);
        }

    }
    public void onClickProblemas(View view){
    }
    public void onClickEntrarPublico(View view){
        Intent intent = new Intent(this, PagesGestorPublic.class);
        startActivity(intent);
    }
    public void onClickEmail(View view){
        editTextEmail.setFocusable(true);
    }
    public void onClickPassword(View view){
        editTextPassword.setFocusable(true);
    }
}
