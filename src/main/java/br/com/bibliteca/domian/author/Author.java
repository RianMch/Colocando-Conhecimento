package br.com.bibliteca.domian.author;


import br.com.bibliteca.domian.dto.author.AuthorDto;
import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public Author(AuthorDto authorDto){
        this.name=authorDto.name();
        this.nationality= authorDto.nationality();
        this.DateOfBirth= authorDto.DateOfBirth();
    }



}
