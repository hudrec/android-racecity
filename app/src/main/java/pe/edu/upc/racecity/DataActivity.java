package pe.edu.upc.racecity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Symtext.ttf");
        Button avanzar_btn = (Button) findViewById(R.id.avanzar);
        EditText nombre_txt = (EditText) findViewById(R.id.nombre);
        avanzar_btn.setTypeface(typeface);
        nombre_txt.setTypeface(typeface);
    }

    public void pasar(View view){
        EditText nombre_txt = (EditText) findViewById(R.id.nombre);
        String nombre = nombre_txt.getText().toString();

        if (ConnectionHelper.webAppSession == null || nombre.isEmpty()) {
            System.out.println("webAppSession is null or name is empty");
            return;
        }

        Intent auto = new Intent(DataActivity.this, AutoActivity.class);
        auto.putExtra("nombre", nombre);
        startActivity(auto);

    }

}
