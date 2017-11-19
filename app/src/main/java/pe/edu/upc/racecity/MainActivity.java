package pe.edu.upc.racecity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.connectsdk.device.ConnectableDevice;
import com.connectsdk.device.DevicePicker;
import com.connectsdk.discovery.DiscoveryManager;
import com.connectsdk.service.WebOSTVService;
import com.connectsdk.service.capability.listeners.ResponseListener;
import com.connectsdk.service.command.ServiceCommandError;
import com.connectsdk.service.sessions.WebAppSession;
import com.connectsdk.service.sessions.WebAppSessionListener;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DiscoveryManager.init(getApplicationContext());
        ConnectionHelper.discoveryManager = DiscoveryManager.getInstance();
        ConnectionHelper.discoveryManager.start();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Symtext.ttf");
        Button conectar_button = (Button) findViewById(R.id.btn_conectar);
        Button entrar_btn = (Button) findViewById(R.id.entrar);
        entrar_btn.setTypeface(typeface);
        conectar_button.setTypeface(typeface);

    }

    public WebAppSessionListener webAppListener = new WebAppSessionListener() {
        @Override
        public void onReceiveMessage(WebAppSession webAppSession, Object o) {

//            if(o.equals("conectado")){
//                entrar();
//            }
//            if(o.equals("empezarJuego"))
//                iniciarJuego();
//            if(o.equals("tuTurno"))
//                findViewById(R.id.movimiento).setEnabled(true);
        }

        @Override
        public void onWebAppSessionDisconnect(WebAppSession webAppSession) {

        }
    };

    public void conectar(View v){
        DevicePicker picker = new DevicePicker(this);
        AlertDialog dialog = picker.getPickerDialog("Seleccionar dispositivo", new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectionHelper.connectableDevice = (ConnectableDevice) parent.getItemAtPosition(position);
                ConnectionHelper.webOSTVService = (WebOSTVService) ConnectionHelper.connectableDevice.getServiceByName("webOS TV");
                ConnectionHelper.webOSTVService.connect();
                //Join
                ConnectionHelper.webOSTVService.joinWebApp("desaplg", new WebAppSession.LaunchListener() {
                    @Override
                    public void onError(ServiceCommandError serviceCommandError) {
                        ConnectionHelper.webOSTVService.launchWebApp("desaplg", new WebAppSession.LaunchListener() {
                            @Override
                            public void onSuccess(WebAppSession webAppSession) {
                                Button conectar_button = (Button) findViewById(R.id.btn_conectar);
                                conectar_button.setText(ConnectionHelper.connectableDevice.getFriendlyName());
                                Button entrar_btn = (Button) findViewById(R.id.entrar);
                                conectar_button.setTextColor(Color.parseColor("#fe0030"));
                                entrar_btn.setTextColor(Color.parseColor("#9ad035"));
                                ConnectionHelper.webAppSession = webAppSession;
//                                findViewById(R.id.button).setEnabled(true);
//                                findViewById(R.id.nombreJugador).setEnabled(true);
                                webAppSession.setWebAppSessionListener(webAppListener);
                                ConnectionHelper.webAppSession.setWebAppSessionListener(webAppListener);
//                                startActivity(new Intent(getApplicationContext(), DataActivity.class));

                            }

                            @Override
                            public void onError(ServiceCommandError serviceCommandError) {

                            }
                        });
                    }
                    @Override
                    public void onSuccess(WebAppSession webAppSession) {

                        ConnectionHelper.webAppSession = webAppSession;
//                        findViewById(R.id.entrar).setEnabled(true);
                        webAppSession.setWebAppSessionListener(webAppListener);
                        ConnectionHelper.webAppSession.setWebAppSessionListener(webAppListener);
//                        startActivity(new Intent(getApplicationContext(), DataActivity.class));

                    }
                });
            }
        });
        dialog.show();
    }

    public void entrar(View view){
        Intent juego = new Intent(MainActivity.this, DataActivity.class);
        startActivity(juego);
    }
}
