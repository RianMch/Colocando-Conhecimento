package br.com.bibliteca.domian.dto.user;

import br.com.bibliteca.domian.role.Role;
import br.com.bibliteca.domian.role.UserBook;

public record UsersListingDto(Long id, String name, int age, String email, Role role) {
    public UsersListingDto(UserBook userBook){
        this(userBook.getId(), userBook.getName(), userBook.getAge(), userBook.getEmail(), userBook.getRoles());
    }
}
