package br.com.cadastroninja.controllers.response;

import br.com.cadastroninja.entities.mission.rank.DifficultyRank;
import br.com.cadastroninja.entities.ninja.Ninja;
import lombok.Builder;

import java.util.List;

@Builder
public record ResponseMission(Long id, String name, DifficultyRank difficulty, List<Ninja> ninja) {
}
