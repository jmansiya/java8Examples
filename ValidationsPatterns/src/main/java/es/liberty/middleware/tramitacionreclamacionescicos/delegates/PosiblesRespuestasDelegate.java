package es.liberty.middleware.tramitacionreclamacionescicos.delegates;

import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.PreCondicionesPosiblesRespuestas;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.Mensaje;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.ReclamacionCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.UltimoMensajeCICODIA;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.PreCondicionesPosiblesRespuestasModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;


public class PosiblesRespuestasDelegate {
    /*
    Este método lo voy a comentar únicamente para probar el método get MensajeCICODIAEntrada

    public List<Mensaje> getPosiblesMensajeDeRepuesta(String idReclamacion){
        List<Mensaje> mensajesPosibleRepuesta = new ArrayList<>();
        
        return null;
    }
    */
    public UltimoMensajeCICODIA getMensajeCICODIAEntrada(final PreCondicionesPosiblesRespuestasModel preCondiciones, final ReclamacionCicos reclamacion){
        List<PreCondicionesPosiblesRespuestas> existePosibleRespuesta = Stream.of(PreCondicionesPosiblesRespuestas.values()).filter(e -> e.getCondition().test(preCondiciones)).collect(Collectors.toList());

        if(existePosibleRespuesta != null && existePosibleRespuesta.size() == 1){
            return existePosibleRespuesta.get(0).getObtenerDatosConsultaPosiblesRespuestas().apply(reclamacion);
        } else {
            System.out.println("Error se cumplen mas de una condición.");
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
