package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.ReclamacionCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.UltimoMensajeCICODIA;

import java.util.List;

public class PostCondicionesFiltroPosiblesRespuestas {
    //Aquí deberemos poner si es necesario el objeto Siniestro. con los campos que son necesarios.
    // existe contrario asociada, referencia a poliza de contrario?? No sirven los datos de CCCHDR y CLMMAT?
    //También necesitamos los datos de si existe reserva G01 para dicho siniestro.
    private ReclamacionCicos reclamacionCicos;

    private UltimoMensajeCICODIA mensajeCICODIA;

    private List<MensajeDialogoCicos> dialogoCicos;

    private List<MensajeDialogoCicos> posiblesRespuestasCICODIA;

    public List<MensajeDialogoCicos> getPosiblesRespuestasCICODIA() {
        return posiblesRespuestasCICODIA;
    }

    public void setPosiblesRespuestasCICODIA(List<MensajeDialogoCicos> posiblesRespuestasCICODIA) {
        this.posiblesRespuestasCICODIA = posiblesRespuestasCICODIA;
    }

    public ReclamacionCicos getReclamacionCicos() {
        return reclamacionCicos;
    }

    public void setReclamacionCicos(ReclamacionCicos reclamacionCicos) {
        this.reclamacionCicos = reclamacionCicos;
    }

    public UltimoMensajeCICODIA getMensajeCICODIA() {
        return mensajeCICODIA;
    }

    public void setMensajeCICODIA(UltimoMensajeCICODIA mensajeCICODIA) {
        this.mensajeCICODIA = mensajeCICODIA;
    }

    public List<MensajeDialogoCicos> getDialogoCicos() {
        return dialogoCicos;
    }

    public void setDialogoCicos(List<MensajeDialogoCicos> dialogoCicos) {
        this.dialogoCicos = dialogoCicos;
    }
}
