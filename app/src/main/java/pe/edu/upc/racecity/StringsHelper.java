package pe.edu.upc.racecity;

public class StringsHelper {

    //Parameters
    public static String ACTION = "accion";
    public static String RESULT = "resultado";
    public static String PLAYER = "nombre";
    public static String COLOR = "color";
    public static String DIFFICULTY = "dificultad";
    public static String WORD = "palabra";
    public static String TIPO = "tipo";
    public static String DIRECCION = "direccion";

    //Acciones enviadas
    public static final String CONNECT_TV = "conectarTV";
    public static final String CONNECT_PLAYER = "conectarJugador";
    public static final String REQUEST_START = "empezarJuego";

    public static final String FINISH_GAME = "salir";
    public static final String PLAY_AGAIN = "volverAjugar";
    public static final String SHOW_ABOUT = "mostrarCreditos";
    public static final String ENVIAR_EVENTO = "enviarEvento";


    public static final String DISCONNECT_PLAYER = "desconectarJugador";

    //Acciones recibidas
    public static final String LOAD_INPUT = "cargarInicio";
    public static final String ENABLE_START = "puedeIniciar";
    public static final String UNABLE_START = "bloquearInicio";
    public static final String IS_DRAWER = "esDibujante";

    public static final String START_TURN = "esTurno";
    public static final String END_TURN = "terminarTurno";
    public static final String GAME_WINNER = "ganadorJuego";
    public static final String CLOSE_APP = "cerrarAplicacion";
    public static final String START_OVER = "cargarNuevoInicio";
    public static final String SUCCESS_CONNECTION = "conexionExitosa";
    public static final String BLOQUEO_EXITOSO = "bloqueoExitoso";
    public static final String JUEGO_CANCELADO = "juegoCancelado";
    public static final String JUEGO_FINALIZADO = "juegoFinalizado";
    public static final String LIMIT_PLAYERS = "limiteJugadores";

    public static final String PERDER_VIDA = "perdio";

    public static final String REINICIAR_JUEGO = "cargarNuevoInicio";
    public static final String LOADING_GAME = "cargandoJuego";
    public static final String INVALID_MOVEMENT = "movimientoInvalido";
}