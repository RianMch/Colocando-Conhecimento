package br.com.bibliteca.domian.dto.user;

import br.com.bibliteca.domian.role.Role;
import br.com.bibliteca.domian.role.User;

public record UsersListingDto(Long id, String name, int age, String email, Role role) {
    public UsersListingDto(User user){
        this(user.getId(), user.getName(), user.getAge(), user.getEmail(), user.getRoles());
    }
}
