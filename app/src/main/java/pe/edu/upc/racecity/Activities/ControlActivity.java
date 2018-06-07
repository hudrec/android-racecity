package pe.edu.upc.racecity.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.connectsdk.service.capability.listeners.ResponseListener;
import com.connectsdk.service.command.ServiceCommandError;

import pe.edu.upc.racecity.ConnectionHelper;
import pe.edu.upc.racecity.JsonHelper;
import pe.edu.upc.racecity.R;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        // Incializar variables
        ImageView iv_izquierda, iv_derecha;
        iv_izquierda = (ImageView) findViewById(R.id.iv_izquierda);
        iv_izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "izquierda"),
                        new ResponseListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                System.out.println("envio izquierda ");
                                System.out.println(o);
                            }

                            @Override
                            public void onError(ServiceCommandError serviceCommandError) {
                                System.out.println("error");
                            }
                        }
                );
            }
        });

        iv_derecha = (ImageView) findViewById(R.id.iv_derecha);
        iv_derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "derecha"),
                        new ResponseListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                System.out.println("envio derecha ");
                                System.out.println(o);
                            }

                            @Override
                            public void onError(ServiceCommandError serviceCommandError) {
                                System.out.println("error");
                            }
                        }
                );
            }
        });
        
    }
}
