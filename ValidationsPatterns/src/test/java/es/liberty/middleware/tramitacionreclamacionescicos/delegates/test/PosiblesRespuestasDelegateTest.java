package es.liberty.middleware.tramitacionreclamacionescicos.delegates.test;

import es.liberty.middleware.tramitacionreclamacionescicos.delegates.PosiblesRespuestasDelegate;
import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.ConvenioEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.DireccionMensajeEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.enums.PosicionCompaniaEnum;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.MensajeDialogoCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.ReclamacionCicos;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.UltimoMensajeCICODIA;
import es.liberty.middleware.tramitacionreclamacionescicos.model.reclamacionescicos.validations.model.PreCondicionesPosiblesRespuestasModel;
import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class PosiblesRespuestasDelegateTest {
    private List<MensajeDialogoCicos> dialogoCicos;

    private PosiblesRespuestasDelegate delegate = new PosiblesRespuestasDelegate();

    private PreCondicionesPosiblesRespuestasModel preCondiciones;

    private ReclamacionCicos reclamacion;

    @Before
    public void setUp() throws Exception {
        preCondiciones = mock(PreCondicionesPosiblesRespuestasModel.class);
        reclamacion = mock(ReclamacionCicos.class);
    }

    @Test
    public void posibleResponderCodigoUltimoMensajeISUltimoMensaje (){
        MensajeDialogoCicos ultimoMensaje = this.getMensajeCicos("500", DireccionMensajeEnum.RECIBIDO, PosicionCompaniaEnum.ACREEDORA, new Date());
        MensajeDialogoCicos mensajeAnterior = this.getMensajeCicos("300", DireccionMensajeEnum.EMITIDO, PosicionCompaniaEnum.ACREEDORA, new Date());

        dialogoCicos = getListadoMensajesDialogoRemitidoEstadoCorrecto(mensajeAnterior, ultimoMensaje);

        when(reclamacion.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(reclamacion.getMensajeAnterior()).thenReturn(mensajeAnterior);
        when(reclamacion.getConvenio()).thenReturn(ConvenioEnum.ASCIDE);
        when(preCondiciones.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(preCondiciones.getDialogoCompletoReclamacion()).thenReturn(dialogoCicos);

        UltimoMensajeCICODIA mensajeAEnviarACicoDIA = delegate.getMensajeCICODIAEntrada(preCondiciones, reclamacion);

        assertEquals(mensajeAEnviarACicoDIA.getCodUltimoMensaje(), ultimoMensaje.getKey());
        verify(reclamacion, times(2)).getUltimoMensaje();
        verify(reclamacion, times(0)).getMensajeAnterior();
    }

    @Test
    public void ultimoMensajeEmitidoPosibleRespuesta(){
        MensajeDialogoCicos ultimoMensaje = this.getMensajeCicos("607", DireccionMensajeEnum.EMITIDO, PosicionCompaniaEnum.ACREEDORA, new Date());
        MensajeDialogoCicos mensajeAnterior = this.getMensajeCicos("300", DireccionMensajeEnum.RECIBIDO, PosicionCompaniaEnum.ACREEDORA, new Date());
        dialogoCicos = getListadoMensajesDialogoRemitidoEstadoCorrecto(mensajeAnterior, ultimoMensaje);

        when(reclamacion.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(reclamacion.getMensajeAnterior()).thenReturn(mensajeAnterior);
        when(reclamacion.getConvenio()).thenReturn(ConvenioEnum.ASCIDE);
        when(preCondiciones.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(preCondiciones.getDialogoCompletoReclamacion()).thenReturn(dialogoCicos);

        UltimoMensajeCICODIA mensajeAEnviarACicoDIA = delegate.getMensajeCICODIAEntrada(preCondiciones, reclamacion);

        assertEquals(mensajeAEnviarACicoDIA.getCodUltimoMensaje(), mensajeAnterior.getKey());
        verify(reclamacion, times(0)).getUltimoMensaje();
        verify(reclamacion, times(2)).getMensajeAnterior();  //Puesto que ahora las posibles respuestas son del mensaje anterior.
    }

    /*
    Este test habría que comprobarlo con el funcionamiento del mensaje de fraude.
    Probablemente debamos revistar el campo de CCCHDR Fraude en lugar del codigo del ultimo mensaje.
     */
    @Test
    public void imposibleResponderMensajeUltimoMensajeRecibidoConfirmacionFraude(){
        MensajeDialogoCicos ultimoMensaje = this.getMensajeCicos("411", DireccionMensajeEnum.RECIBIDO, PosicionCompaniaEnum.DEUDORA, new Date());
        MensajeDialogoCicos mensajeAnterior = this.getMensajeCicos("410", DireccionMensajeEnum.EMITIDO, PosicionCompaniaEnum.DEUDORA, new Date());
        dialogoCicos = getListadoMensajesDialogoRemitidoEstadoCorrecto(mensajeAnterior, ultimoMensaje);

        when(reclamacion.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(reclamacion.getMensajeAnterior()).thenReturn(mensajeAnterior);
        when(reclamacion.getConvenio()).thenReturn(ConvenioEnum.ASCIDE);
        when(preCondiciones.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(preCondiciones.getDialogoCompletoReclamacion()).thenReturn(dialogoCicos);

        UltimoMensajeCICODIA mensajeAEnviarACicoDIA = delegate.getMensajeCICODIAEntrada(preCondiciones, reclamacion);

        assertNull(mensajeAEnviarACicoDIA);

        verify(reclamacion, times(0)).getUltimoMensaje();
        verify(reclamacion, times(0)).getMensajeAnterior();  //Puesto que ahora las posibles respuestas son del mensaje anterior.
    }

    @Test
    public void imposibleResponderMensajeRecibido203(){
        Date fechaActual = new Date();
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.DAY_OF_MONTH, -15);
        fechaActual = hoy.getTime();

        MensajeDialogoCicos ultimoMensaje = this.getMensajeCicos("203", DireccionMensajeEnum.RECIBIDO, PosicionCompaniaEnum.DEUDORA, fechaActual);
        MensajeDialogoCicos mensajeAnterior = this.getMensajeCicos("322", DireccionMensajeEnum.EMITIDO, PosicionCompaniaEnum.DEUDORA, new Date());
        dialogoCicos = getListadoMensajesDialogoRemitidoEstadoCorrecto(mensajeAnterior, ultimoMensaje);

        when(reclamacion.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(reclamacion.getMensajeAnterior()).thenReturn(mensajeAnterior);
        when(reclamacion.getConvenio()).thenReturn(ConvenioEnum.ASCIDE);
        when(preCondiciones.getUltimoMensaje()).thenReturn(ultimoMensaje);
        when(preCondiciones.getDialogoCompletoReclamacion()).thenReturn(dialogoCicos);

        UltimoMensajeCICODIA mensajeAEnviarACicoDIA = delegate.getMensajeCICODIAEntrada(preCondiciones, reclamacion);

        assertNull(mensajeAEnviarACicoDIA);

        verify(reclamacion, times(0)).getUltimoMensaje();
        verify(reclamacion, times(0)).getMensajeAnterior();  //Puesto que ahora las posibles respuestas son del mensaje anterior.
    }

    private MensajeDialogoCicos getMensajeCicos(final String codigo, final DireccionMensajeEnum direccion, final PosicionCompaniaEnum posicion, final Date fechaRecepcion){
        MensajeDialogoCicos mensaje = new MensajeDialogoCicos();

        mensaje.setDireccion(direccion);
        mensaje.setKey(codigo);  //Mensaje sin ningun tipo de excepcion.
        mensaje.setValue(MessageFormat.format("Mensaje {0} Direccion: {1} Posición Cía: {2}", codigo, direccion, posicion));
        mensaje.setPosicionCia(posicion);
        mensaje.setFechaRecepcion(fechaRecepcion);
        return mensaje;
    }

    private List<MensajeDialogoCicos> getListadoMensajesDialogoRemitidoEstadoCorrecto(MensajeDialogoCicos mensajeAnterior, MensajeDialogoCicos ultimoMensaje){
        List<MensajeDialogoCicos> dialogo = new ArrayList<>();

        MensajeDialogoCicos mensaje = new MensajeDialogoCicos();
        int codMensaje = 0;
        DireccionMensajeEnum direccion = DireccionMensajeEnum.RECIBIDO;
        for (int i = 0; i < 10; i++){
            mensaje = new MensajeDialogoCicos();
            if (i%2 == 0) {
                direccion =  DireccionMensajeEnum.RECIBIDO;
            } else {
                direccion =  DireccionMensajeEnum.EMITIDO;
            }

            codMensaje = 150 + (i * 10);
            mensaje.setKey("" + codMensaje);
            mensaje.setValue(MessageFormat.format("Mensaje. Código: {0} Dirección: {1}",codMensaje, direccion));
            mensaje.setDireccion(direccion);

            dialogo.add(mensaje);
        }

        dialogo.add(mensajeAnterior);
        dialogo.add(ultimoMensaje);

        return dialogo;
    }
}
