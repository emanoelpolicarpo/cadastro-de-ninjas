package br.com.cadastroninja.controllers;

import br.com.cadastroninja.controllers.request.RequestNinja;
import br.com.cadastroninja.controllers.response.ResponseNinja;
import br.com.cadastroninja.services.NinjaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/konoha/ninjas")
@RequiredArgsConstructor
public class NinjaController {
    private final NinjaService ninjaService;

    @GetMapping
    public ResponseEntity<List<ResponseNinja>> findAll() {
        return ResponseEntity.ok(ninjaService.getAll());
    }

    @PostMapping
    public ResponseEntity<ResponseNinja> create(@RequestBody RequestNinja requestNinja) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ninjaService.create(requestNinja));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseNinja> findById(@PathVariable Long id) {
        return ninjaService.findById(id)
                .map(ninja -> ResponseEntity.ok(ninja))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ninjaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseNinja> UpdateMission(@PathVariable Long id, @RequestBody RequestNinja requestNinja) {
        return ninjaService.update(id, requestNinja)
                .map(ninja -> ResponseEntity.ok(ninja))
                .orElse(ResponseEntity.notFound().build());
    }
}
