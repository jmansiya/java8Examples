package es.liberty.middleware.tramitacionreclamacionescicos.model.enums;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.PostCondicionesFiltroPosiblesRespuestas;
import es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.validacionespostposiblesrespuestas.FiltrarPosiblesRespuestasCICODIA;
import es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.validacionespostposiblesrespuestas.ValidacionesPostCicoDia;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public enum PostCondicionesPosiblesRespuestas {
    MENSAJE_100(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_100, FiltrarPosiblesRespuestasCICODIA.isMensaje100PosibleRespuest),
    MENSAJE_104(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_104, FiltrarPosiblesRespuestasCICODIA.isMensaje104PosibleRespuesta),
    MENSAJE_280(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_280, FiltrarPosiblesRespuestasCICODIA.isMensaje280PosibleRespuest),
    MENSAJE_212(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_212, FiltrarPosiblesRespuestasCICODIA.isMensaje212PosibleRespuest),
    MENSAJE_282(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_282, FiltrarPosiblesRespuestasCICODIA.isMensaje282PosibleRespuest),
    MENSAJE_287(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_287, FiltrarPosiblesRespuestasCICODIA.isMensaje287PosibleRespuest),
    MENSAJE_632(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_632, null),
    MENSAJE_502(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_502, null),
    MENSAJE_519(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_519, null),
    MENSAJE_411(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_411, null),
    MENSAJE_203(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_203, null),
    MENSAJE_410(ValidacionesPostCicoDia.POSIBLE_RESPUESTA_410, null);

    private Predicate<List<MensajeDialogoCicos>> condicion;

    private Consumer<PostCondicionesFiltroPosiblesRespuestas> comprobarPostValidaciones;

    private PostCondicionesPosiblesRespuestas(Predicate<List<MensajeDialogoCicos>> condicion, Consumer<PostCondicionesFiltroPosiblesRespuestas> comprobarPostValidaciones) {
        this.condicion = condicion;
        this.comprobarPostValidaciones = comprobarPostValidaciones;
    }

    public Predicate<List<MensajeDialogoCicos>> getCondicion() {
        return condicion;
    }

    public Consumer<PostCondicionesFiltroPosiblesRespuestas> getComprobarPostValidaciones() {
        return comprobarPostValidaciones;
    }
}
