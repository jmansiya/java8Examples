package es.liberty.middleware.tramitacionreclamacionescicos.delegates;

import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.PreCondicionesPosiblesRespuestas;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.Mensaje;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.ReclamacionCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.UltimoMensajeCICODIA;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.PreCondicionesPosiblesRespuestasModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

@Component
public class PosiblesRespuestasDelegate {
    public List<Mensaje> getPosiblesMensajeDeRepuesta(String idReclamacion){
        List<Mensaje> mensajesPosibleRepuesta = new ArrayList<>();
        
        return null;
    }

    private UltimoMensajeCICODIA getMensajeCICODIAEntrada(final PreCondicionesPosiblesRespuestasModel preCondiciones, final ReclamacionCicos reclamacion){
        Optional<PreCondicionesPosiblesRespuestas> existePosibleRespuesta = Stream.of(PreCondicionesPosiblesRespuestas.values()).filter(e -> e.getCondition().test(preCondiciones)).findFirst();

        if (existePosibleRespuesta.isPresent()){
            return existePosibleRespuesta.get().getObtenerDatosConsultaPosiblesRespuestas().apply(reclamacion);
        }

        return null;
    }

    private List<Mensaje> getMensajesPosibleRespuesta(){
        return new ArrayList<>();
    }

    private ReclamacionCicos getReclamacionCicos(String idReclamacion) {
        return new ReclamacionCicos();
    }
    
    private MensajeDialogoCicos getUltimoMensajeReclamacionCicos(ReclamacionCicos reclamacion) {
        assertNotNull(reclamacion);

        return reclamacion.getUltimoMensaje();
    }
    
    private List<MensajeDialogoCicos> getDialogoReclamacion(ReclamacionCicos reclamacion){
        assertNotNull(reclamacion);
        
        return new ArrayList<MensajeDialogoCicos>();       
        
    }
}
