package pe.edu.upc.racecity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import com.connectsdk.service.capability.listeners.ResponseListener;
import com.connectsdk.service.command.ServiceCommandError;

public class AutoActivity extends AppCompatActivity {
    String nombre = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Symtext.ttf");
        Button avanzar_btn = (Button) findViewById(R.id.send);
        avanzar_btn.setTypeface(typeface);
    }

//    public void sentData(View view){
//        Bundle extras = getIntent().getExtras();
//        if(extras !=null) {
//            String nombre = extras.getString("nombre");
//        }
//    }
    public void sentData(View v){
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            nombre = extras.getString("nombre");
        }
        Intent auto = new Intent(AutoActivity.this, MandoActivity.class);
        startActivity(auto);
//        ConnectionHelper.webAppSession.sendMessage(new JSONObject() {
//            {
//                try {
//                    put("nombre", nombre);
//                    put("carro", nombre);
//                } catch (JSONException ex) {
//                }
//            }
//        }, new ResponseListener<Object>() {
//            @Override
//            public void onSuccess(Object o) {
//
//            }
//
//            @Override
//            public void onError(ServiceCommandError serviceCommandError) {
//
//            }
//        });
    }

    public void seleccionar(View view){
        view.setBackgroundColor(0);
    }
}
