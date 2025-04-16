package br.com.cadastroninja.entities.ninja;

import br.com.cadastroninja.entities.mission.Mission;
import br.com.cadastroninja.entities.ninja.rank.NinjaRank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "img_url")
    private String imgUrl;
    @Enumerated(EnumType.STRING)
    private NinjaRank rank;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
