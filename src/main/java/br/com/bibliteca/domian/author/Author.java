package br.com.bibliteca.domian.author;


import br.com.bibliteca.domian.dto.author.AuthorDto;
import br.com.bibliteca.domian.dto.author.UpdateAuthorDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="author")
@Table(name="authors")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The author's name is required ")
    private String name;
    @NotBlank (message = "The nationality of the author is mandatory ")
    private String nationality;
    private LocalDate DateOfBirth;
    private Genre genre;
    private boolean ativo;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public Author(AuthorDto authorDto){
        this.ativo=true;
        this.name=authorDto.name();
        this.nationality= authorDto.nationality();
        this.DateOfBirth= authorDto.DateOfBirth();
        this.genre=authorDto.genre();
    }

    public void delete(){
        this.ativo=false;
    }
    public void update(@Valid UpdateAuthorDto updateAuthorDto){
        if(updateAuthorDto.name()!=null){
            this.name= updateAuthorDto.name();
        }
        if(updateAuthorDto.genre()!=null){
            this.genre=updateAuthorDto.genre();
        }
        if(updateAuthorDto.nationality()!=null){
            this.nationality= updateAuthorDto.nationality();
        }
        if(updateAuthorDto.DateOfBirth()!=null){
            this.DateOfBirth=updateAuthorDto.DateOfBirth();
        }
    }





}
