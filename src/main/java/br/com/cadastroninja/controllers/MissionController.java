package br.com.cadastroninja.controllers;

import br.com.cadastroninja.controllers.request.RequestMission;
import br.com.cadastroninja.controllers.response.ResponseMission;
import br.com.cadastroninja.services.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/konoha/missoes")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    @GetMapping
    public ResponseEntity<List<ResponseMission>> GetAllMissions() {
        return ResponseEntity
                .ok(missionService.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponseMission> CreateMission(@RequestBody RequestMission requestMission) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(missionService.save(requestMission));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMission> GetMissionById(@PathVariable Long id) {
        return missionService.getById(id)
                .map(mission -> ResponseEntity.ok(mission))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteMission(@PathVariable Long id) {
        missionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMission> UpdateMission(@PathVariable Long id, @RequestBody RequestMission requestMission) {
        return missionService.update(id, requestMission)
                .map(mission -> ResponseEntity.ok(mission))
                .orElse(ResponseEntity.notFound().build());
    }
}
