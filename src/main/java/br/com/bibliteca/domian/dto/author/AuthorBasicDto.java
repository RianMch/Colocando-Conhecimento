package br.com.bibliteca.domian.dto.author;

import br.com.bibliteca.domian.author.Author;

public record AuthorBasicDto(Long id, String name) {
    public AuthorBasicDto(Author author){
        this(author.getId(), author.getName());
    }
}
