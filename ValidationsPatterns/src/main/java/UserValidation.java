
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

interface UserValidation extends BiFunction<User, Optional<List<String>>, Boolean> {
    static UserValidation nameIsNotNull(){
        return (user, lista) -> StringUtils.isNotEmpty(user.getNombre());
    }

    static UserValidation emailIsNotNull(){
        return (user, lista) -> StringUtils.isNotEmpty(user.getEmail());
    }

    static UserValidation emailFormatoCorrecto(){
        return (user, lista) -> user.getEmail().contains("@");
    }

    static UserValidation isMayorDeEdad(){
        return (user, lista) -> user.getEdad() > 18;
    }

    static UserValidation nameEstaEnLaLista(){
        return (user, lista) -> {
          if (lista.isPresent()) {
            return  lista.get().contains(user.getNombre());
          }

          return false;
        };
    }

    default UserValidation add(UserValidation other){
        return (user, lista) -> this.apply(user, lista) && other.apply(user, lista);

    }
}
