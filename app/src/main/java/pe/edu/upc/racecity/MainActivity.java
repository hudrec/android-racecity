package pe.edu.upc.racecity;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.connectsdk.device.ConnectableDevice;
import com.connectsdk.device.DevicePicker;
import com.connectsdk.discovery.DiscoveryManager;
import com.connectsdk.service.WebOSTVService;
import com.connectsdk.service.capability.listeners.ResponseListener;
import com.connectsdk.service.command.ServiceCommandError;
import com.connectsdk.service.sessions.WebAppSession;
import com.connectsdk.service.sessions.WebAppSessionListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DiscoveryManager.init(getApplicationContext());
        ConnectionHelper.discoveryManager = DiscoveryManager.getInstance();
        ConnectionHelper.discoveryManager.start();
    }

    public WebAppSessionListener webAppListener = new WebAppSessionListener() {
        @Override
        public void onReceiveMessage(WebAppSession webAppSession, Object o) {

            if(o.equals("conectado"))
                startActivity(new Intent(getApplicationContext(), DataActivity.class));

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
                                ConnectionHelper.webAppSession = webAppSession;
//                                findViewById(R.id.button).setEnabled(true);
//                                findViewById(R.id.nombreJugador).setEnabled(true);
                                webAppSession.setWebAppSessionListener(webAppListener);
                                ConnectionHelper.webAppSession.setWebAppSessionListener(webAppListener);
                            }

                            @Override
                            public void onError(ServiceCommandError serviceCommandError) {

                            }
                        });
                    }
                    @Override
                    public void onSuccess(WebAppSession webAppSession) {
                        ConnectionHelper.webAppSession = webAppSession;
//                        findViewById(R.id.button).setEnabled(true);
//                        findViewById(R.id.nombreJugador).setEnabled(true);
                        webAppSession.setWebAppSessionListener(webAppListener);
                        ConnectionHelper.webAppSession.setWebAppSessionListener(webAppListener);
                    }
                });
            }
        });
        dialog.show();
    }
}
