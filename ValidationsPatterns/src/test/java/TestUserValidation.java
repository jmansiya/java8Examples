import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;


public class TestUserValidation {
    private User usuario = null;
    private List<String> nombresBusqueda = null;

    @Before
    public void setUp() throws Exception {
        usuario = new User();
        usuario.setEdad(19);
        usuario.setEmail("jmansiya@gmail.com");
        usuario.setNombre("José Mansilla García-Gil");

        nombresBusqueda = new ArrayList<>();
        nombresBusqueda.add("Juan");
        nombresBusqueda.add("Jose");
        nombresBusqueda.add("Luis");
        nombresBusqueda.add("Antonio");
    }

    @Test
    public void nameNotNull(){
        final UserValidation userValidation = UserValidation.nameIsNotNull();

        assertThat(userValidation.apply(usuario, null), is(true));
    }

    @Test
    public void errorNameIsEmpty() {
        usuario.setNombre("");
        final UserValidation validation = UserValidation.nameIsNotNull();

        assertThat(validation.apply(usuario, null), is(false));
    }

    @Test
    public void emailIsCorrect() {
        //Combinacion de dos validaciones
        final UserValidation validacion = UserValidation.emailIsNotNull().add(UserValidation.emailFormatoCorrecto());

        assertThat(validacion.apply(usuario, null), is(true));

    }


    @Test
    public void emailIsNotCorrect() {
        //Combinacion de dos validaciones
        usuario.setEmail("jose");
        final UserValidation validacion = UserValidation.emailIsNotNull().add(UserValidation.emailFormatoCorrecto());

        assertThat(validacion.apply(usuario, null), is(false));
    }

    @Test
    public void usuarioMayorDeEdad() {
        //Combinacion de dos validaciones
        final UserValidation validacion = UserValidation.isMayorDeEdad();

        assertThat(validacion.apply(usuario, null), is(true));
    }

    @Test
    public void nameEstaEnLista() {
        usuario.setNombre("Jose");
        final UserValidation validacion = UserValidation.nameEstaEnLaLista();

        assertThat(validacion.apply(usuario, java.util.Optional.ofNullable(nombresBusqueda)), is(true));
    }
}
