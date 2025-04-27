package br.com.bibliteca.controller;
import br.com.bibliteca.domian.dto.user.UpdateUserDto;
import br.com.bibliteca.domian.dto.user.UserDetailsDTO;
import br.com.bibliteca.domian.dto.user.UsersDto;
import br.com.bibliteca.domian.dto.user.UsersListingDto;
import br.com.bibliteca.domian.repository.RepositoryUser;
import br.com.bibliteca.domian.role.User;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RepositoryUser repositoryUser;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrarUser(@RequestBody @Valid UsersDto usersDto, UriComponentsBuilder uribuilder){
        var user=new User(usersDto);
        repositoryUser.save(user);
        var uri=uribuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailsDTO(user));

    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateUserDto updateUserDto){
        var user=repositoryUser.getReferenceById(updateUserDto.id());
        user.update(updateUserDto);
        return ResponseEntity.ok(new UserDetailsDTO(user));

    }
    @GetMapping
    public ResponseEntity<Page<UsersListingDto>>list(@PageableDefault(size = 10,page = 0,sort = {"id"})Pageable pageable){
        var page=repositoryUser.findAllByAtivoTrue(pageable).map(UsersListingDto::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var user=repositoryUser.getReferenceById(id);
        user.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detelha(@PathVariable Long id){
        var user=repositoryUser.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailsDTO(user));
    }



}
