package br.com.bibliteca.domian.dto.user;

import br.com.bibliteca.domian.role.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(@NotNull Long id,
                            String name,
                            int age,
                            @Email
                            String email,
                            String password,
                            Role role) {
}
