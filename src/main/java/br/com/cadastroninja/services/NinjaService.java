package br.com.cadastroninja.services;

import br.com.cadastroninja.controllers.request.RequestNinja;
import br.com.cadastroninja.controllers.response.ResponseNinja;
import br.com.cadastroninja.entities.mission.Mission;
import br.com.cadastroninja.entities.ninja.Ninja;
import br.com.cadastroninja.mapper.NinjaMapper;
import br.com.cadastroninja.repositories.MissionRepository;
import br.com.cadastroninja.repositories.NinjaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NinjaService {
    private final NinjaRepository repository;
    private final MissionRepository missionRepository;

    public List<ResponseNinja> getAll() {
        return repository.findAll()
                .stream()
                .map(NinjaMapper::toResponseNinja)
                .toList();
    }

    public ResponseNinja create(RequestNinja request) {
        Ninja savedNinja = repository.save(NinjaMapper.toNinja(request));
        savedNinja.setMission(foundMissions(request.missions()));
        return NinjaMapper.toResponseNinja(savedNinja);
    }

    public Optional<ResponseNinja> findById(Long id) {
        return repository.findById(id)
                .map(NinjaMapper::toResponseNinja);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<ResponseNinja> update(Long id, RequestNinja requestNinja) {
        Optional<Ninja> ninjaFound = repository.findById(id);
        if (ninjaFound.isPresent()) {
            Mission mission = foundMissions(requestNinja.missions());

            Ninja ninja = ninjaFound.get();

            ninja.setName(requestNinja.name());
            ninja.setEmail(requestNinja.email());
            ninja.setIdade(requestNinja.idade());
            ninja.setImgUrl(requestNinja.imgUrl());
            ninja.setRank(requestNinja.rank());

            ninja.setMission(mission);

            repository.save(ninja);
            return Optional.of(NinjaMapper.toResponseNinja(ninja));
        }

        return Optional.empty();
    }

    private Mission foundMissions(Mission missionRequest) {
        if (missionRequest != null) return missionRepository.findById(missionRequest.getId()).get();

        return null;
    }
}