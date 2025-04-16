package br.com.cadastroninja.controllers.response;

import lombok.Builder;

@Builder
public record ResponseUser(Long id, String name, String email) {
}
