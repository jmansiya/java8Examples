package es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas;

import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.DireccionMensajeEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.ConstantesValidacionesPosiblesRespuestas;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.PreCondicionesPosiblesRespuestasModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;


public class Validaciones {
    
    public static final Predicate<PreCondicionesPosiblesRespuestasModel> ULTIMO_MENSAJE_ES_RECIBIDO = (preCondiciones) -> preCondiciones.getUltimoMensaje().getDireccion().equals(DireccionMensajeEnum.RECIBIDO);
    
    public static final Predicate<PreCondicionesPosiblesRespuestasModel> ULTIMO_MENSAJE_ES_EMITIDO_ES_EXCEPCION_POSIBLE_RESPUESTA = (preCondiciones) -> ConstantesValidacionesPosiblesRespuestas.listaPrecondicionExceptionEmision.contains(preCondiciones.getUltimoMensaje().getKey());

    public static final Predicate<PreCondicionesPosiblesRespuestasModel> EXISTE_CONFIRMACION_DE_FRAUDE = (preCondiciones) -> preCondiciones.getDialogoCompletoReclamacion().stream().anyMatch(e -> StringUtils.equalsIgnoreCase(e.getKey(), ConstantesValidacionesPosiblesRespuestas.codMensajeFraudeConfirmado));

    public static final Predicate<PreCondicionesPosiblesRespuestasModel> EXISTE_SOLICITUD_DE_ABONO_OFERTA_MOTIVADA_EN_MES_EN_CURSO = (preCondiciones) -> {
        Date fechaActual = new Date();

        return (preCondiciones.getDialogoCompletoReclamacion().stream().anyMatch(e -> StringUtils.equalsIgnoreCase(e.getKey(), ConstantesValidacionesPosiblesRespuestas.codMensajeAbonoOfertaMotivada)) &&
                    DateUtils.truncatedCompareTo(fechaActual, preCondiciones.getUltimoMensaje().getFechaRecepcion(), Calendar.MONTH) == 0);
    };

    //Tenemos que comprobar que esta condición sea indiferente de si son enviadas o no recibidas.
    public static final Predicate<PreCondicionesPosiblesRespuestasModel> SELECCIONAMOS_MENSAJE_ANTERIOR = (preCondiciones) -> ConstantesValidacionesPosiblesRespuestas.preCondicionesSeleccionamosMensajeAnterior.contains(preCondiciones.getUltimoMensaje().getKey());

    public static final Predicate<PreCondicionesPosiblesRespuestasModel> ULTIMO_MENSAJE_RECIBIDO_ESTADO_CORRECTO = ULTIMO_MENSAJE_ES_RECIBIDO.and(EXISTE_CONFIRMACION_DE_FRAUDE.negate()).and(EXISTE_SOLICITUD_DE_ABONO_OFERTA_MOTIVADA_EN_MES_EN_CURSO.negate()).and(SELECCIONAMOS_MENSAJE_ANTERIOR.negate());

    public static final Predicate<PreCondicionesPosiblesRespuestasModel> ULTIMO_MENSAJE_RECIBIDO_EXCEPCIONES = (ULTIMO_MENSAJE_ES_RECIBIDO.negate().and(ULTIMO_MENSAJE_ES_EMITIDO_ES_EXCEPCION_POSIBLE_RESPUESTA)).or(SELECCIONAMOS_MENSAJE_ANTERIOR);
}

