package br.com.giulianabezerra.springbootcleanarch.infra.gateways;

import br.com.giulianabezerra.springbootcleanarch.application.gateways.UserEntityMapper;
import br.com.giulianabezerra.springbootcleanarch.application.gateways.UserGateway;
import br.com.giulianabezerra.springbootcleanarch.domain.entity.User;
import br.com.giulianabezerra.springbootcleanarch.infra.persistence.UserEntity;
import br.com.giulianabezerra.springbootcleanarch.infra.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway {// Esse gateway vai interagir com o repositorio

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomainObject) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObject);
        UserEntity savedObject = userRepository.save(userEntity);
        return userEntityMapper.toDomainObject(savedObject);
    }
}
