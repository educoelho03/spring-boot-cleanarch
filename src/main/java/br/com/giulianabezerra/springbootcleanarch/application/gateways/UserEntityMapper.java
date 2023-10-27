package br.com.giulianabezerra.springbootcleanarch.application.gateways;

import br.com.giulianabezerra.springbootcleanarch.domain.entity.User;
import br.com.giulianabezerra.springbootcleanarch.infra.persistence.UserEntity;

public class UserEntityMapper {
    public UserEntity toEntity(User UserDomainObject){
        return new UserEntity(
                UserDomainObject.username(),
                UserDomainObject.password(),
                UserDomainObject.email(),
                UserDomainObject.endereco()
        );
    }

    public User toDomainObject(UserEntity userEntity){
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getEndereco()
        );
    }
}
