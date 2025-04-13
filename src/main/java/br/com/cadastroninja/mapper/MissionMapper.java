package br.com.cadastroninja.mapper;

import br.com.cadastroninja.controllers.request.RequestMission;
import br.com.cadastroninja.controllers.response.ResponseMission;
import br.com.cadastroninja.entities.mission.Mission;
import lombok.experimental.UtilityClass;


@UtilityClass
public class MissionMapper {


    public static Mission toMission(RequestMission request) {

        return Mission
                .builder()
                .name(request.name())
                .difficulty(request.difficulty())
                .build();
    }

    public static ResponseMission toMissionResponse(Mission mission) {
        return ResponseMission
                .builder()
                .id(mission.getId())
                .name(mission.getName())
                .difficulty(mission.getDifficulty())
                .build();
    }
}
