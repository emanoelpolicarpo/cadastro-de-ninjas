package br.com.cadastroninja.controllers.response;

import br.com.cadastroninja.entities.mission.Mission;
import br.com.cadastroninja.entities.ninja.rank.NinjaRank;
import lombok.Builder;

@Builder
public record ResponseNinja(Long id, String name, int idade, String email, String imgUrl, NinjaRank rank, Mission missons) {
}
