package es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.validacionespostposiblesrespuestas;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;

import java.util.List;
import java.util.function.BiPredicate;

public class ConstantesValidacionPostPosiblesRespuestas {
    public static final BiPredicate<List<MensajeDialogoCicos>, String> existeMensajeEnLaLista = (listaMensajes, codMensaje) -> listaMensajes.contains(codMensaje);
}
