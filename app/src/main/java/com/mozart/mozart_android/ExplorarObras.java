package com.mozart.mozart_android;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExplorarObras extends ActionBarActivity {
    Toolbar toolbar;
    TextView textViewTitulo,textViewDescripcion,textViewCategoria;
    EditText editTextTitulo,editTextDescripcion,editTextCategoria;
    Typeface RobotoThin,RobotoRegular,RobotoMedium,RobotoLight,iconFonts,enterFont;
    Button buttonSubirObra;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorar_obras);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Explorar Obras");
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
        textViewTitulo = (TextView) findViewById(R.id.TextViewTitulo);
        textViewDescripcion = (TextView) findViewById(R.id.TextViewDescripcion);
        textViewCategoria = (TextView) findViewById(R.id.TextViewCategoria);

        editTextTitulo = (EditText) findViewById(R.id.EditTextTitulo);
        editTextDescripcion = (EditText) findViewById(R.id.EditTextDescripcion);
        editTextCategoria = (EditText) findViewById(R.id.EditTextCategoria);

        buttonSubirObra = (Button) findViewById(R.id.buttonSubirObra);

        RobotoLight = Typeface.createFromAsset(this.getAssets(),"Roboto-Light.ttf");
        RobotoRegular = Typeface.createFromAsset(this.getAssets(),"Roboto-Regular.ttf");
        RobotoMedium = Typeface.createFromAsset(this.getAssets(),"Roboto-Medium.ttf");

        textViewTitulo.setTypeface(RobotoRegular);
        textViewDescripcion.setTypeface(RobotoRegular);
        textViewCategoria.setTypeface(RobotoRegular);
        editTextTitulo.setTypeface(RobotoMedium);
        editTextDescripcion.setTypeface(RobotoMedium);
        editTextCategoria.setTypeface(RobotoMedium);
        buttonSubirObra.setTypeface(RobotoRegular);
    }
}
