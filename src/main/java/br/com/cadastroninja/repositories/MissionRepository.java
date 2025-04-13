package br.com.cadastroninja.repositories;

import br.com.cadastroninja.entities.mission.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
