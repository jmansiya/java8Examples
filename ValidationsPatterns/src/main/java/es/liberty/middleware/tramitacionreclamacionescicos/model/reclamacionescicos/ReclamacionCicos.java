package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos;

import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.ConvenioEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.EstadoReclamacionesEnum;

import java.io.Serializable;
import java.util.Date;

public class ReclamacionCicos implements Serializable {

    private static final long serialVersionUID = -6695854516545941268L;

    private String idReclamacion;

    private String idReclamacionProvisional;

    private MensajeDialogoCicos ultimoMensaje;

    private MensajeDialogoCicos mensajeAnterior;

    private EstadoReclamacionesEnum estadoReclamacion;

    private ConvenioEnum convenio;

    private Date fechaAccidente;

    private String observaciones;

    public String getIdReclamacion() {
        return idReclamacion;
    }

    public void setIdReclamacion(String idReclamacion) {
        this.idReclamacion = idReclamacion;
    }

    public String getIdReclamacionProvisional() {
        return idReclamacionProvisional;
    }

    public void setIdReclamacionProvisional(String idReclamacionProvisional) {
        this.idReclamacionProvisional = idReclamacionProvisional;
    }

    public MensajeDialogoCicos getUltimoMensaje() {
        return ultimoMensaje;
    }

    public void setUltimoMensaje(MensajeDialogoCicos ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }

    public EstadoReclamacionesEnum getEstadoReclamacion() {
        return estadoReclamacion;
    }

    public void setEstadoReclamacion(EstadoReclamacionesEnum estadoReclamacion) {
        this.estadoReclamacion = estadoReclamacion;
    }

    public ConvenioEnum getConvenio() {
        return convenio;
    }

    public void setConvenio(ConvenioEnum convenio) {
        this.convenio = convenio;
    }

    public Date getFechaAccidente() {
        return fechaAccidente;
    }

    public void setFechaAccidente(Date fechaAccidente) {
        this.fechaAccidente = fechaAccidente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public MensajeDialogoCicos getMensajeAnterior() {
        return mensajeAnterior;
    }

    public void setMensajeAnterior(MensajeDialogoCicos mensajeAnterior) {
        this.mensajeAnterior = mensajeAnterior;
    }
}
