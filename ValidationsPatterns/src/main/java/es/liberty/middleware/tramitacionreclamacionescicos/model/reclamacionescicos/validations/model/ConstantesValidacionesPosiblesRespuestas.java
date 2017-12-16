package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model;

import java.util.Arrays;
import java.util.List;

public class ConstantesValidacionesPosiblesRespuestas {
    
    private ConstantesValidacionesPosiblesRespuestas() {
        super();
    }

    public static String codMensajeFraudeConfirmado = "411";
    public static String codMensajeAbonoOfertaMotivada = "203";

    public static List<String> listaPrecondicionExceptionEmision = Arrays.asList("607", "608", "609", "615");

    public static List<String> preCondicionesSeleccionamosMensajeAnterior = Arrays.asList("609", "615", "313", "314", "323", "324", "410", "349");
}
