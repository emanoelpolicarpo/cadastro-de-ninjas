package br.com.cadastroninja.controllers.request;

import lombok.Builder;

@Builder
public record RequestUser(String name, String email, String password) {
}
