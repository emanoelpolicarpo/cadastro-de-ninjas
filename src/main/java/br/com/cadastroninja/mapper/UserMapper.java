package br.com.cadastroninja.mapper;

import br.com.cadastroninja.controllers.request.RequestUser;
import br.com.cadastroninja.controllers.response.ResponseUser;
import br.com.cadastroninja.entities.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toUser(RequestUser request) {
        return User
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static ResponseUser toResponse(User user) {
        return ResponseUser
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
