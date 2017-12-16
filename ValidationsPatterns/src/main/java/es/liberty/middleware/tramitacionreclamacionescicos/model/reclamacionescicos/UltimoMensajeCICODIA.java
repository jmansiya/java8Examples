package es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos;

public class UltimoMensajeCICODIA {
    private String codUltimoMensaje;
    private String codConvenioUltimoMensaje;
    private String posicionCiaUltimoMensaje;
    
    public String getCodUltimoMensaje() {
        return codUltimoMensaje;
    }
    
    public void setCodUltimoMensaje(String codUltimoMensaje) {
        this.codUltimoMensaje = codUltimoMensaje;
    }
    
    public String getCodConvenioUltimoMensaje() {
        return codConvenioUltimoMensaje;
    }
    
    public void setCodConvenioUltimoMensaje(String codConvenioUltimoMensaje) {
        this.codConvenioUltimoMensaje = codConvenioUltimoMensaje;
    }
    
    public String getPosicionCiaUltimoMensaje() {
        return posicionCiaUltimoMensaje;
    }
    
    public void setPosicionCiaUltimoMensaje(String posicionCiaUltimoMensaje) {
        this.posicionCiaUltimoMensaje = posicionCiaUltimoMensaje;
    }
}
