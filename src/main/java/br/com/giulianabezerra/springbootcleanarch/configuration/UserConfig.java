package br.com.giulianabezerra.springbootcleanarch.configuration;

import br.com.giulianabezerra.springbootcleanarch.application.gateways.UserEntityMapper;
import br.com.giulianabezerra.springbootcleanarch.application.gateways.UserGateway;
import br.com.giulianabezerra.springbootcleanarch.application.useCases.CreateUserInteractor;
import br.com.giulianabezerra.springbootcleanarch.infra.controller.UserDTOMapper;
import br.com.giulianabezerra.springbootcleanarch.infra.gateways.UserRepositoryGateway;
import br.com.giulianabezerra.springbootcleanarch.infra.persistence.UserRepository;
import org.springframework.context.annotation.Bean;

public class UserConfig {

    @Bean
    CreateUserInteractor createUserCase(UserGateway userGateway){
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper){
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper(){
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper(){
        return new UserDTOMapper();
    }
}
