package br.com.bibliteca.domian;

import br.com.bibliteca.domian.role.Role;
import jakarta.persistence.*;
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
@Entity (name="user")
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ig;
    private String name;
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100,message = "Age should not be greater than 100")
    private int age;
    @Email(message="Email should be valid")
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role roles;


}
