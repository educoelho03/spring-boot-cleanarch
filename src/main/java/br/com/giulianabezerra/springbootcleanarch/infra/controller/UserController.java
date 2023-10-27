package br.com.giulianabezerra.springbootcleanarch.infra.controller;

import br.com.giulianabezerra.springbootcleanarch.application.gateways.UserEntityMapper;
import br.com.giulianabezerra.springbootcleanarch.application.useCases.CreateUserInteractor;
import br.com.giulianabezerra.springbootcleanarch.domain.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final CreateUserInteractor createUserInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserInteractor, UserDTOMapper userDTOMapper) {
        this.createUserInteractor = createUserInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public CreateUserResponse create(@RequestBody CreateUserRequest request){
        User userObject = userDTOMapper.toUser(request);
        User user = createUserInteractor.createUser(userObject);
        return userDTOMapper.toResponse(user);
    }
}
