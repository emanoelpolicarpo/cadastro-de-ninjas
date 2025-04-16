package br.com.cadastroninja.mapper;

import br.com.cadastroninja.controllers.request.RequestNinja;
import br.com.cadastroninja.controllers.response.ResponseNinja;
import br.com.cadastroninja.entities.ninja.Ninja;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NinjaMapper {
    public static Ninja toNinja(RequestNinja request) {

        return Ninja
                .builder()
                .name(request.name())
                .idade(request.idade())
                .email(request.email())
                .imgUrl(request.imgUrl())
                .rank(request.rank())
                .mission(request.missions())
                .build();
    }

    public static ResponseNinja toResponseNinja(Ninja ninja) {
        return ResponseNinja
                .builder()
                .id(ninja.getId())
                .name(ninja.getName())
                .idade(ninja.getIdade())
                .email(ninja.getEmail())
                .imgUrl(ninja.getImgUrl())
                .rank(ninja.getRank())
                .missions(ninja.getMission())
                .build();
    }
}
