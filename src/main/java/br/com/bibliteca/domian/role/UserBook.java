package br.com.bibliteca.domian.role;

import br.com.bibliteca.domian.dto.user.UpdateUserDto;
import br.com.bibliteca.domian.dto.user.UsersDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="user_entity")
@Table(name="users")
public class UserBook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100,message = "Age should not be greater than 100")
    private int age;
    @Email(message="Email should be valid")
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role roles;

    private boolean ativo;

    public UserBook(UsersDto dto){
        this.ativo=true;
        this.name=dto.name();
        this.age=dto.age();
        this.email= dto.email();
        this.password= dto.password();
        this.roles=dto.role();
    }
    public void update(@Valid UpdateUserDto dados){
        if(dados.name()!=null){
            this.name= dados.name();
        }
        if(dados.age()>=18&&dados.age()<120){
            this.age=dados.age();
        }
        if(dados.email()!=null){
            this.email= dados.email();
        }
        if(dados.password()!=null){
            this.password= dados.password();
        }

    }

    public void delete(){
        this.ativo=false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
