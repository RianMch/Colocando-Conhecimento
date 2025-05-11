package br.com.bibliteca.domian.role;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Admin")
public class Administrator extends UserBook {


}
