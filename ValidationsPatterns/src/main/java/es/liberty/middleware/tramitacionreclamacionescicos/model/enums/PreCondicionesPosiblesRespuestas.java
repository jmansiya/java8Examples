package es.liberty.middleware.tramitacionreclamacionescicos.model.enums;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.ReclamacionCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.UltimoMensajeCICODIA;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.PreCondicionesPosiblesRespuestasModel;
import es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.ObtenerDatosConsultaPosiblesRespuestas;
import es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.Validaciones;

import java.util.function.Function;
import java.util.function.Predicate;

public enum PreCondicionesPosiblesRespuestas {
    ULTIMO_MENSAJE_RECIBIDO_ESTADO_CORRECTO(Validaciones.ULTIMO_MENSAJE_RECIBIDO_ESTADO_CORRECTO,
        ObtenerDatosConsultaPosiblesRespuestas.getUltimoMensaje),
    ULT_MENSAJE_EXCEPCION_MENSAJE_ANTERIOR(Validaciones.ULTIMO_MENSAJE_RECIBIDO_EXCEPCIONES,
            ObtenerDatosConsultaPosiblesRespuestas.getMensajeAnterior);

    private Predicate<PreCondicionesPosiblesRespuestasModel> condition;

    private Function<ReclamacionCicos, UltimoMensajeCICODIA> obtenerDatosConsultaPosiblesRespuestas;

    private PreCondicionesPosiblesRespuestas(Predicate<PreCondicionesPosiblesRespuestasModel> condition, Function<ReclamacionCicos, UltimoMensajeCICODIA> obtenerDatosConsultaPosiblesRespuestas) {
        this.condition = condition;
        this.obtenerDatosConsultaPosiblesRespuestas = obtenerDatosConsultaPosiblesRespuestas;
    }

    public Predicate<PreCondicionesPosiblesRespuestasModel> getCondition() {
        return condition;
    }

    public Function<ReclamacionCicos, UltimoMensajeCICODIA> getObtenerDatosConsultaPosiblesRespuestas() {
        return obtenerDatosConsultaPosiblesRespuestas;
    }
}
