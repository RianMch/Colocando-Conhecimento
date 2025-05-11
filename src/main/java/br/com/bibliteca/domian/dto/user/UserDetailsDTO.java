package br.com.bibliteca.domian.dto.user;

import br.com.bibliteca.domian.role.UserBook;

public record UserDetailsDTO(Long id, String name,String email ,int age, boolean ativo) {
    public UserDetailsDTO(UserBook userBook){
        this(userBook.getId(), userBook.getName(), userBook.getEmail(), userBook.getAge(), userBook.isAtivo());
    }


}
