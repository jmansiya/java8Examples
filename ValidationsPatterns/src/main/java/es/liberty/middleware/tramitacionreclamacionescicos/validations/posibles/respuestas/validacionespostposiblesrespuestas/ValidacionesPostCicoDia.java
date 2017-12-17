package es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.validacionespostposiblesrespuestas;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.ConstantesValidacionesPosiblesRespuestas;

import java.util.List;
import java.util.function.Predicate;

public class ValidacionesPostCicoDia {

    //Este mensaje 100 se devuelve como posible respuesta a codMensaje 501, 503, 101, 102 o 100 en la tabla CICODIA??
    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_100 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje100);

    //Este mensaje 104 nos llegará desde la tabla CICODIA como posible respuesta al último mensaje recibido??
    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_104 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje104);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_280 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje280);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_212 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje212);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_282 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje282);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_287 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje287);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_632 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje632);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_502 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje502);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_519 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje519);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_411 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje411);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_203 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje203);

    public static final Predicate<List<MensajeDialogoCicos>> POSIBLE_RESPUESTA_410 = (listaPosiblesRespuestas) -> ConstantesValidacionPostPosiblesRespuestas.existeMensajeEnLaLista.test(listaPosiblesRespuestas, ConstantesValidacionesPosiblesRespuestas.codMensaje410);
}

