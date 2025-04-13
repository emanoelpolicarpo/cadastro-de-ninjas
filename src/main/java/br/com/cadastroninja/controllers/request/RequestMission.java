package br.com.cadastroninja.controllers.request;

import br.com.cadastroninja.entities.mission.rank.DifficultyRank;
import lombok.Builder;

@Builder
public record RequestMission(String name, DifficultyRank difficulty){
}
