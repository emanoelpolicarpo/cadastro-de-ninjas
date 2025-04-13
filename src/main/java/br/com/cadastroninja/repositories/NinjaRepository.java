package br.com.cadastroninja.repositories;

import br.com.cadastroninja.entities.ninja.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}
