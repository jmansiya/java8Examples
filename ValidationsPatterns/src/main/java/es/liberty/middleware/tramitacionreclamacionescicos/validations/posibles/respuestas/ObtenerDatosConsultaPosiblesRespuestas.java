package es.liberty.middleware.tramitacionreclamacionescicos.validations.posibles.respuestas;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.ReclamacionCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.UltimoMensajeCICODIA;

import java.util.function.Function;

public class ObtenerDatosConsultaPosiblesRespuestas {
    public static final Function<ReclamacionCicos, UltimoMensajeCICODIA> getUltimoMensaje = (reclamacion) -> {
        UltimoMensajeCICODIA ultimoMensajeCICODIA = new UltimoMensajeCICODIA();
        ultimoMensajeCICODIA.setCodConvenioUltimoMensaje(reclamacion.getConvenio().name());
        ultimoMensajeCICODIA.setCodUltimoMensaje(reclamacion.getUltimoMensaje().getKey());
        ultimoMensajeCICODIA.setPosicionCiaUltimoMensaje(reclamacion.getUltimoMensaje().getPosicionCia().name());

        return ultimoMensajeCICODIA;
    };

    public static final Function<ReclamacionCicos, UltimoMensajeCICODIA> getMensajeAnterior = (reclamacion) -> {
        UltimoMensajeCICODIA ultimoMensajeCICODIA = new UltimoMensajeCICODIA();
        ultimoMensajeCICODIA.setCodConvenioUltimoMensaje(reclamacion.getConvenio().name());
        ultimoMensajeCICODIA.setCodUltimoMensaje(reclamacion.getMensajeAnterior().getKey());
        ultimoMensajeCICODIA.setPosicionCiaUltimoMensaje(reclamacion.getMensajeAnterior().getPosicionCia().name());

        return ultimoMensajeCICODIA;
    };

}
