package pe.edu.upc.racecity.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        //Tipografia
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Symtext.ttf");

        // Incializar variables
        ImageView iv_izquierda, iv_derecha,iv_arriba,iv_abajo,
                iv_amarillo,iv_rojo,iv_verde,iv_azul,
                iv_jugador;

        //Nombre del jugador
        TextView name_jugador;
        name_jugador =  (TextView) findViewById(R.id.tv_nombre);
        name_jugador.setText(getIntent().getStringExtra("nombre"));
        name_jugador.setTypeface(typeface);

        //Color del jugador
        String color_auto = "jugador_"+ getIntent().getStringExtra("color");
        iv_jugador = (ImageView) findViewById(R.id.iv_jugador);
        iv_jugador.setImageResource(getResources().getIdentifier(color_auto, "drawable", getPackageName()));

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
        iv_abajo = (ImageView) findViewById(R.id.iv_abajo);
        iv_abajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "abajo"),
                        new ResponseListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                System.out.println("envio abajo ");
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
        iv_arriba = (ImageView) findViewById(R.id.iv_arriba);
        iv_arriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "arriba"),
                        new ResponseListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                System.out.println("envio arriba ");
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
        iv_azul = (ImageView) findViewById(R.id.iv_azul);
        iv_azul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "btnazul"),
                        new ResponseListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                System.out.println("envio azul ");
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
        iv_amarillo = (ImageView) findViewById(R.id.iv_amarillo);
        iv_amarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "btnamarillo"),
                        new ResponseListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                System.out.println("envio amarillo ");
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
        iv_rojo = (ImageView) findViewById(R.id.iv_rojo);
        iv_rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "btnrojo"),
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
        iv_verde = (ImageView) findViewById(R.id.iv_verde);
        iv_verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectionHelper.webAppSession.sendMessage(JsonHelper.enviarEvento("mover", "btnverde"),
                        new ResponseListener<Object>() {
                            @Override
                            public void onSuccess(Object o) {
                                System.out.println("envio verde ");
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
    @Override
    public void onBackPressed() {
        System.out.println("Disable back");

    }
}
