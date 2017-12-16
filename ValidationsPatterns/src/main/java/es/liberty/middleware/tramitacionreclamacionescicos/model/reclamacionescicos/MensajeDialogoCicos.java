package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos;

import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.DireccionMensajeEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.EstadoEnvioEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.PosicionCompaniaEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.RazonCulpaEnum;

import java.io.Serializable;
import java.util.Date;

public class MensajeDialogoCicos implements Serializable {

    private static final long serialVersionUID = -578427179976934945L;

    private String key;

    private String value;

    private String infoAdicional;

    private String infoAdicionalMatricula;

    private Date infoAdicionalFechaCancelacion;

    private Date infoAdicionalFechaEfecto;

    private Integer secuencia;

    private Date fechaEmision;

    private Date fechaCaducidad;

    private Date fechaRecepcion;

    private DireccionMensajeEnum direccion;

    private PosicionCompaniaEnum posicionCia;

    private String mensajeFraude;

    private Date fechaEmisionRecepcionFraude;

    private DireccionMensajeEnum direccionMensajeFraude;

    private RazonCulpaEnum razonCulpa;

    private EstadoEnvioEnum estadoEnvio;


    private String estacionTrabajo;

    private Date fechaTransaccion;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getInfoAdicionalMatricula() {
        return infoAdicionalMatricula;
    }

    public void setInfoAdicionalMatricula(String infoAdicionalMatricula) {
        this.infoAdicionalMatricula = infoAdicionalMatricula;
    }

    public Date getInfoAdicionalFechaCancelacion() {
        return infoAdicionalFechaCancelacion;
    }

    public void setInfoAdicionalFechaCancelacion(Date infoAdicionalFechaCancelacion) {
        this.infoAdicionalFechaCancelacion = infoAdicionalFechaCancelacion;
    }

    public Date getInfoAdicionalFechaEfecto() {
        return infoAdicionalFechaEfecto;
    }

    public void setInfoAdicionalFechaEfecto(Date infoAdicionalFechaEfecto) {
        this.infoAdicionalFechaEfecto = infoAdicionalFechaEfecto;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public DireccionMensajeEnum getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionMensajeEnum direccion) {
        this.direccion = direccion;
    }

    public PosicionCompaniaEnum getPosicionCia() {
        return posicionCia;
    }

    public void setPosicionCia(PosicionCompaniaEnum posicionCia) {
        this.posicionCia = posicionCia;
    }

    public String getMensajeFraude() {
        return mensajeFraude;
    }

    public void setMensajeFraude(String mensajeFraude) {
        this.mensajeFraude = mensajeFraude;
    }

    public Date getFechaEmisionRecepcionFraude() {
        return fechaEmisionRecepcionFraude;
    }

    public void setFechaEmisionRecepcionFraude(Date fechaEmisionRecepcionFraude) {
        this.fechaEmisionRecepcionFraude = fechaEmisionRecepcionFraude;
    }

    public DireccionMensajeEnum getDireccionMensajeFraude() {
        return direccionMensajeFraude;
    }

    public void setDireccionMensajeFraude(DireccionMensajeEnum direccionMensajeFraude) {
        this.direccionMensajeFraude = direccionMensajeFraude;
    }

    public RazonCulpaEnum getRazonCulpa() {
        return razonCulpa;
    }

    public void setRazonCulpa(RazonCulpaEnum razonCulpa) {
        this.razonCulpa = razonCulpa;
    }

    public EstadoEnvioEnum getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvioEnum estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public String getEstacionTrabajo() {
        return estacionTrabajo;
    }

    public void setEstacionTrabajo(String estacionTrabajo) {
        this.estacionTrabajo = estacionTrabajo;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

}
