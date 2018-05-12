package pe.edu.upc.racecity;

/**
 * Created by Daniela on 30/09/2015.
 */


import com.connectsdk.service.sessions.WebAppSession;
import com.connectsdk.service.sessions.WebAppSessionListener;

import pe.edu.upc.racecity.Activities.MainActivity;

public class DemoListener implements WebAppSessionListener{

    MainActivity mainAct = new MainActivity();
    @Override
    public void onReceiveMessage(WebAppSession webAppSession, Object o) {
        //if(o.equals("conectado"))
          //  mainAct.activarBotones();
    }

    @Override
    public void onWebAppSessionDisconnect(WebAppSession webAppSession) {

    }
}
