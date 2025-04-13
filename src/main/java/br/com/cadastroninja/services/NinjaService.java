package br.com.cadastroninja.services;

import br.com.cadastroninja.controllers.request.RequestNinja;
import br.com.cadastroninja.controllers.response.ResponseNinja;
import br.com.cadastroninja.entities.ninja.Ninja;
import br.com.cadastroninja.mapper.NinjaMapper;
import br.com.cadastroninja.repositories.NinjaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NinjaService {
    private final NinjaRepository repository;

    public List<ResponseNinja> getAll() {
        return repository.findAll()
                .stream()
                .map(NinjaMapper::toResponseNinja)
                .toList();
    }

    public ResponseNinja create(RequestNinja request) {
        Ninja savedNinja = repository.save(NinjaMapper.toNinja(request));
        return NinjaMapper.toResponseNinja(savedNinja);
    }

    public Optional<ResponseNinja> findById(Long id) {
        return repository.findById(id)
                .map(NinjaMapper::toResponseNinja);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
