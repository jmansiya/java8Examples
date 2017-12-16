package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.filter;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class FilterReclamacionesCicos implements Serializable {

    private static final long serialVersionUID = -3575963873348023677L;

    private String idSiniestro;

    @NotNull
    private String estadoReclamacionesCicos;

    private String direccionPosicionUltimoMensaje;

    private String referenciaCicos;

    private String companiaContraria;

    private String matriculaPropia;

    private String matriculaContraria;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaCaducidad;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaEmision;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaRecepcion;

    private String tramitadasPor;

    private String opcion;

    public String getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(String idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public String getEstadoReclamacionesCicos() {
        return estadoReclamacionesCicos;
    }

    public void setEstadoReclamacionesCicos(String estadoReclamacionesCicos) {
        this.estadoReclamacionesCicos = estadoReclamacionesCicos;
    }

    public String getDireccionPosicionUltimoMensaje() {
        return direccionPosicionUltimoMensaje;
    }

    public void setDireccionPosicionUltimoMensaje(String direccionPosicionUltimoMensaje) {
        this.direccionPosicionUltimoMensaje = direccionPosicionUltimoMensaje;
    }

    public String getReferenciaCicos() {
        return referenciaCicos;
    }

    public void setReferenciaCicos(String referenciaCicos) {
        this.referenciaCicos = referenciaCicos;
    }

    public String getCompaniaContraria() {
        return companiaContraria;
    }

    public void setCompaniaContraria(String companiaContraria) {
        this.companiaContraria = companiaContraria;
    }

    public String getMatriculaPropia() {
        return matriculaPropia;
    }

    public void setMatriculaPropia(String matriculaPropia) {
        this.matriculaPropia = matriculaPropia;
    }

    public String getMatriculaContraria() {
        return matriculaContraria;
    }

    public void setMatriculaContraria(String matriculaContraria) {
        this.matriculaContraria = matriculaContraria;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getTramitadasPor() {
        return tramitadasPor;
    }

    public void setTramitadasPor(String tramitadasPor) {
        this.tramitadasPor = tramitadasPor;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

}
