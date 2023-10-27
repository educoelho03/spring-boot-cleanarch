package br.com.giulianabezerra.springbootcleanarch.application.gateways;

import br.com.giulianabezerra.springbootcleanarch.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserGateway {

    User createUser(User user);

}
