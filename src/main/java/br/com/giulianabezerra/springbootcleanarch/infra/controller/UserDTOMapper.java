package br.com.giulianabezerra.springbootcleanarch.infra.controller;

import br.com.giulianabezerra.springbootcleanarch.domain.entity.User;

public class UserDTOMapper {
    public CreateUserResponse toResponse(User user){
        return new CreateUserResponse(
                user.username(),
                user.email(),
                user.endereco()
        );
    }

    public User toUser(CreateUserRequest request){
        return new User(
                request.username(),
                request.password(),
                request.email(),
                request.endereco()
        );
    }
}
