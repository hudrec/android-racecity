package pe.edu.upc.racecity;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonHelper {

    public static JSONObject ConnectTv(){
        return getDefaultAction(StringsHelper.CONNECT_TV);
    }

    public static JSONObject ConnectPlayer(String player, String car){
        try {
            JSONObject jsonObject = getDefaultAction(StringsHelper.CONNECT_PLAYER);
            jsonObject.put(StringsHelper.PLAYER, player);
            jsonObject.put(StringsHelper.CAR, car);
            return jsonObject;
        } catch (Exception ex) {
            return null;
        }
    }

    public static JSONObject enviarEvento(String tipo, String direccion){
        try {
            JSONObject jsonObject = getDefaultAction(StringsHelper.ENVIAR_EVENTO);
            jsonObject.put(StringsHelper.TIPO, tipo);
            jsonObject.put(StringsHelper.DIRECCION, direccion);
            return jsonObject;
        } catch (Exception ex) {
            return null;
        }
    }

    public static JSONObject volverJugar(){
        try {
            JSONObject jsonObject = getDefaultAction("volverAjugar");
            return jsonObject;
        } catch (Exception ex) {
            return null;
        }
    }

    public static JSONObject pausarJuego(){
        try {
            JSONObject jsonObject = getDefaultAction("pausa");
            return jsonObject;
        } catch (Exception ex) {
            return null;
        }
    }



    public static JSONObject DisconnectPlayer(){
        try {
            JSONObject jsonObject = getDefaultAction(StringsHelper.DISCONNECT_PLAYER);
            return jsonObject;
        } catch (Exception ex) {
            return null;
        }
    }
    public static JSONObject requestGameStart(){
        return getDefaultAction(StringsHelper.REQUEST_START);
    }


    public static JSONObject showAbout(){

        return getDefaultAction(StringsHelper.SHOW_ABOUT);
    }



    //<editor-fold desc="Para enviar la dificultad escogida por el usuario">

    /**
     * Enum que contiene las dificultades actualmente soportadas, y su
     * respectivo id que será pasado al servicio
     */
    public enum Difficulties{
        EASY("facil"),MEDIUM("intermedio"),HARD("avanzado");
        private String mId;
        Difficulties(String id){
            mId = id;
        }
        public String getId(){
            return mId;
        }
    }




    public static JSONObject close(){
        JSONObject json = getDefaultAction(StringsHelper.FINISH_GAME);
        try {
            json.put(StringsHelper.RESULT,"");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static JSONObject playAgain(){
        JSONObject json = getDefaultAction(StringsHelper.PLAY_AGAIN);
        try {
            json.put(StringsHelper.RESULT,"");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }



    /**
     * Para obtener un object básico conteniendo la acción especificada.
     * Luego podría añadirsele más parámetros al JSONObject si se desea.
     * @param action acción que se le mandará al servidor
     * @return JSONObject cuyo único parámetro es la acción que se pasó en el parámetro
     */
    private static JSONObject getDefaultAction(String action){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(StringsHelper.ACTION, action);
            return jsonObject;
        } catch (Exception ex) {
            return null;
        }
    }
}