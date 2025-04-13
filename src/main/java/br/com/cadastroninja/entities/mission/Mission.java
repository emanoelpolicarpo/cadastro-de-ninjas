package br.com.cadastroninja.entities.mission;

import br.com.cadastroninja.entities.mission.rank.DifficultyRank;
import br.com.cadastroninja.entities.ninja.Ninja;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "difficulty", nullable = false)
    @Enumerated(EnumType.STRING)
    private DifficultyRank difficulty;

    @OneToMany(mappedBy = "mission")
    @JsonIgnore
    private List<Ninja> ninjas;
}
