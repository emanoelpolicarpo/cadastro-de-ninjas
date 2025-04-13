package br.com.cadastroninja.entities.ninja.rank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NinjaRank {
    Kage("Líder de Aldeia", 6),
    Sannin("Título", 5),
    Jonnin("Nível de instrução, podem usar técnicas de nível B", 4),
    Chunnin("Nível de instrução, podem aprender técnicas de nível C", 3),
    Genin("Nível de instrução, podem aprender técnicas de nível D", 2),
    Academy("Nível de instrução inicial", 1);

    private final String descricao;
    private final int nivel;
}
