package pe.edu.upc.racecity.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;
import com.connectsdk.service.capability.listeners.ResponseListener;
import com.connectsdk.service.command.ServiceCommandError;

import pe.edu.upc.racecity.ConnectionHelper;
import pe.edu.upc.racecity.JsonHelper;
import pe.edu.upc.racecity.R;

public class AutoActivity extends AppCompatActivity {
    String nombre = "";
    String carro = "verde";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Symtext.ttf");
        Button avanzar_btn = (Button) findViewById(R.id.send);
        avanzar_btn.setTypeface(typeface);
    }

    public void sentData(View v){
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            nombre = extras.getString("nombre");
        }
        ConnectionHelper.webAppSession.sendMessage(JsonHelper.ConnectPlayer(nombre,carro),
            new ResponseListener<Object>() {
                @Override
                public void onSuccess(Object o) {
                    System.out.println("success");
                }

                @Override
                public void onError(ServiceCommandError serviceCommandError) {
                    System.out.println("error");
                }
            }
        );
        Intent mando = new Intent(AutoActivity.this, ControlActivity.class);
        startActivity(mando);
    }

    public void seleccionar(View view){
        View caraView = (View)findViewById(R.id.autoa);
        caraView.setBackgroundColor(0);
        View carrView = (View)findViewById(R.id.autor);
        carrView.setBackgroundColor(0);
        View carcView = (View)findViewById(R.id.autoc);
        carcView.setBackgroundColor(0);
        View carvView = (View)findViewById(R.id.autov);
        carvView.setBackgroundColor(0);

        carro = String.valueOf(view.getTag());
        view.setBackgroundColor(getResources().getColor(R.color.black_overlay));
    }
}
