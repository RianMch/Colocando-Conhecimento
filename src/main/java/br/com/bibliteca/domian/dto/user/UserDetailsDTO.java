package br.com.bibliteca.domian.dto.user;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.role.User;

public record UserDetailsDTO(Long id, String name,String email ,int age, boolean ativo) {
    public UserDetailsDTO(User user){
        this(user.getId(), user.getName(), user.getEmail(),user.getAge(), user.isAtivo());
    }


}
