package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.ReclamacionCicos;

import java.util.List;

public class PostCondicionesPosiblesRespuestasModel {
    private ReclamacionCicos reclamacionCicos;
    private MensajeDialogoCicos ultimoMensaje;
    private List<MensajeDialogoCicos> dialogoCompletoReclamacion;

    public MensajeDialogoCicos getUltimoMensaje() {
        return ultimoMensaje;
    }

    public void setUltimoMensaje(MensajeDialogoCicos ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }

    public List<MensajeDialogoCicos> getDialogoCompletoReclamacion() {
        return dialogoCompletoReclamacion;
    }

    public void setDialogoCompletoReclamacion(List<MensajeDialogoCicos> dialogoCompletoReclamacion) {
        this.dialogoCompletoReclamacion = dialogoCompletoReclamacion;
    }

    public ReclamacionCicos getReclamacionCicos() {
        return reclamacionCicos;
    }

    public void setReclamacionCicos(ReclamacionCicos reclamacionCicos) {
        this.reclamacionCicos = reclamacionCicos;
    }
}
