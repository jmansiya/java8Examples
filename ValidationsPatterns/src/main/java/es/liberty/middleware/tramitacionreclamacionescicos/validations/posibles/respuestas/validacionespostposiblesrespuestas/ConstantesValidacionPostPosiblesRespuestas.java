package es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.validacionespostposiblesrespuestas;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.function.BiPredicate;

public class ConstantesValidacionPostPosiblesRespuestas {
    public static final BiPredicate<List<MensajeDialogoCicos>, String> existeMensajeEnLaLista = (listaMensajes, codMensaje) -> listaMensajes.stream().anyMatch(e -> StringUtils.equalsIgnoreCase(e.getKey(), codMensaje));
}
