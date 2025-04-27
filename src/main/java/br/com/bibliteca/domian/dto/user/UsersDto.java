package br.com.bibliteca.domian.dto.user;

import br.com.bibliteca.domian.role.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record UsersDto (@NotBlank (message = "User")String name,
                      @Min(value = 18)
                      @Max(value = 120)
                      @NotNull int age,
                      @Email String email,
                      @NotBlank String password,@Valid Role role


){
}
