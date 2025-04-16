package br.com.cadastroninja.services;

import br.com.cadastroninja.controllers.request.RequestMission;
import br.com.cadastroninja.controllers.response.ResponseMission;
import br.com.cadastroninja.entities.mission.Mission;
import br.com.cadastroninja.mapper.MissionMapper;
import br.com.cadastroninja.repositories.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository repository;

    public List<ResponseMission> findAll() {
        return repository.findAll()
                .stream()
                .map(MissionMapper::toMissionResponse)
                .toList();
    }

    public ResponseMission save(RequestMission request) {
        Mission mission = MissionMapper.toMission(request);
        Mission savedMisson = repository.save(mission);
        return MissionMapper.toMissionResponse(savedMisson);

    }

    public Optional<ResponseMission> getById(Long id) {
        return repository.findById(id)
                .map(MissionMapper::toMissionResponse);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<ResponseMission> update(Long id, RequestMission request) {
        Optional<Mission> foundMission = repository.findById(id);
        if (foundMission.isPresent()) {
            Mission mission = foundMission.get();

            mission.setName(request.name());
            mission.setDifficulty(request.difficulty());
            repository.save(mission);
            return Optional.of(MissionMapper.toMissionResponse(mission));
        }
        return Optional.empty();
    }
}
