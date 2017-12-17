package es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas.validacionespostposiblesrespuestas;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.ConstantesValidacionesPosiblesRespuestas;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.PostCondicionesFiltroPosiblesRespuestas;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FiltrarPosiblesRespuestasCICODIA {

    //Consumidor que comprobará si el mensaje 104 es una posible respuesta o no.
    public static final Consumer<PostCondicionesFiltroPosiblesRespuestas> isMensaje104PosibleRespuesta = (filtro) -> {
        //Pendiente realizar las comprobaciones con el siniestro asociado a la reclamación CICOS.
    };

    private static final BiConsumer<PostCondicionesFiltroPosiblesRespuestas, String> eliminarMensajePosible = (filtro, codMensaje) -> {
        filtro.getPosiblesRespuestasCICODIA().removeIf(e -> StringUtils.equalsIgnoreCase(e.getKey(), codMensaje));
    };

    private static final BiPredicate<List<MensajeDialogoCicos>, List<String>> comprobarExisteMensajeEnDialogo = (dialogo, listaCondiciones) -> dialogo.stream().anyMatch(e -> listaCondiciones.contains(e.getKey()));

    public static final Consumer<PostCondicionesFiltroPosiblesRespuestas> isMensaje100PosibleRespuest = (filtro) -> {
        if (ConstantesValidacionesPosiblesRespuestas.postCondicionMensaje100PosibleRespuestaReclamacionAsociada.contains(filtro.getMensajeCICODIA().getCodUltimoMensaje())){
            //Pendiente la comprobación de que la reclamación debe estar enganchada JTEMP = 0
            eliminarMensajePosible.accept(filtro, ConstantesValidacionesPosiblesRespuestas.codMensaje100);
        } else if (!ConstantesValidacionesPosiblesRespuestas.postCondicionMensaje100PosibleRespuestaReclamacionNoAsociada.contains(filtro.getMensajeCICODIA().getCodUltimoMensaje())){
            eliminarMensajePosible.accept(filtro, ConstantesValidacionesPosiblesRespuestas.codMensaje100);
        }
    };

    public static final Consumer<PostCondicionesFiltroPosiblesRespuestas> isMensaje280PosibleRespuest = (filtro) -> {
        //Debe ser el último o la posición es indiferente????, si existe un dialogo cerrado y posteriormente abierto
        //imagion que los anteriores al mensaje de reapertura de reclamación no sirven verdad?
        if (!filtro.getDialogoCicos().stream().anyMatch(e -> StringUtils.equalsIgnoreCase(e.getKey(), ConstantesValidacionesPosiblesRespuestas.codMensaje400))){
            eliminarMensajePosible.accept(filtro, ConstantesValidacionesPosiblesRespuestas.codMensaje280);
        }
    };

    public static final Consumer<PostCondicionesFiltroPosiblesRespuestas> isMensaje282PosibleRespuest = (filtro) -> {
        //Debe ser el último o la posición es indiferente????, si existe un dialogo cerrado y posteriormente abierto
        //imagion que los anteriores al mensaje de reapertura de reclamación no sirven verdad?
        if (!filtro.getDialogoCicos().stream().anyMatch(e -> ConstantesValidacionesPosiblesRespuestas.postCondicionMensaje282PosibleRespuesta.contains(e.getKey()))){
            eliminarMensajePosible.accept(filtro, ConstantesValidacionesPosiblesRespuestas.codMensaje282);
        }
    };

    public static final Consumer<PostCondicionesFiltroPosiblesRespuestas> isMensaje287PosibleRespuest = (filtro) -> {
        //Debe ser el último o la posición es indiferente????, si existe un dialogo cerrado y posteriormente abierto
        //imagion que los anteriores al mensaje de reapertura de reclamación no sirven verdad?
        if (!filtro.getDialogoCicos().stream().anyMatch(e -> StringUtils.equalsIgnoreCase(e.getKey(), ConstantesValidacionesPosiblesRespuestas.codMensaje404))){
            eliminarMensajePosible.accept(filtro, ConstantesValidacionesPosiblesRespuestas.codMensaje287);
        }
    };

    public static final Consumer<PostCondicionesFiltroPosiblesRespuestas> isMensaje212PosibleRespuest = (filtro) -> {
        //El mensaje 212 es posible respuesta para a parte de la entradad 317 Acreedora????
        if (!filtro.getDialogoCicos().stream().anyMatch(e -> StringUtils.equalsIgnoreCase(e.getKey(), ConstantesValidacionesPosiblesRespuestas.codMensaje400))){
            eliminarMensajePosible.accept(filtro, ConstantesValidacionesPosiblesRespuestas.codMensaje212);
        }
    };

}
