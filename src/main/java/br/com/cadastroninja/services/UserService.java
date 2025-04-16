package br.com.cadastroninja.services;

import br.com.cadastroninja.controllers.request.RequestUser;
import br.com.cadastroninja.controllers.response.ResponseUser;
import br.com.cadastroninja.entities.User;
import br.com.cadastroninja.mapper.UserMapper;
import br.com.cadastroninja.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public ResponseUser save(RequestUser requestUser) {
        User saved = repository.save(UserMapper.toUser(requestUser));
        return UserMapper.toResponse(saved);
    }
}
