package br.com.cadastroninja.controllers;

import br.com.cadastroninja.controllers.request.RequestUser;
import br.com.cadastroninja.controllers.response.ResponseUser;
import br.com.cadastroninja.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("konoha/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseUser> register(@RequestBody RequestUser user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(user));
    }
}
