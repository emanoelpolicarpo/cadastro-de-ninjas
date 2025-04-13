package br.com.cadastroninja.controllers.request;

import br.com.cadastroninja.entities.mission.Mission;
import br.com.cadastroninja.entities.ninja.rank.NinjaRank;
import lombok.Builder;

@Builder
public record RequestNinja(String name, int idade, String email, String imgUrl, NinjaRank rank, Mission missions) {
}
