package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model;

import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;

import java.util.List;

public class PreCondicionesPosiblesRespuestasModel {
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
}
