package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model;

import java.util.Arrays;
import java.util.List;

public class ConstantesValidacionesPosiblesRespuestas {
    
    private ConstantesValidacionesPosiblesRespuestas() {
        super();
    }

    public static String codMensaje104 = "104";
    public static String codMensaje280 = "280";
    public static String codMensaje282 = "282";
    public static String codMensaje287 = "287";
    public static String codMensaje632 = "632";
    public static String codMensaje502 = "502";
    public static String codMensaje212 = "212";
    public static String codMensaje519 = "519";
    public static String codMensaje410 = "410";
    public static String codMensaje411 = "411";
    public static String codMensaje203 = "203";
    public static String codMensaje100 = "100";
    public static String codMensaje400 = "400";
    public static String codMensaje404 = "404";
    public static String codMensaje402 = "402";
    public static String codMensaje407 = "407";
    public static String codMensaje408 = "408";

    public static String codMensajeFraudeConfirmado = "411";
    public static String codMensajeAbonoOfertaMotivada = "203";

    public static List<String> listaPrecondicionExceptionEmision = Arrays.asList("607", "608", "609", "615");

    public static List<String> preCondicionesSeleccionamosMensajeAnterior = Arrays.asList("609", "615", "313", "314", "323", "324", "410", "349");

    public static List<String> postCondicionMensaje100PosibleRespuestaReclamacionAsociada = Arrays.asList("501", "503");

    public static List<String> postCondicionMensaje100PosibleRespuestaReclamacionNoAsociada = Arrays.asList("101", "102", codMensaje100);

    public static List<String> postCondicionMensaje282PosibleRespuesta = Arrays.asList(codMensaje402, codMensaje404, codMensaje407, codMensaje408);
}
