package br.com.cadastroninja.entities.mission.rank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DifficultyRank {
    S("Extremamente Difícil", 6),
    A("Muito Difícil", 5),
    B("Difícil", 4),
    C("Média", 3),
    D("Fácil", 2),
    E("Muito Fácil", 1);

    private final String descricao;
    private final int nivel;
}
