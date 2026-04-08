package hu.grofandriska.wotandme.api.model.player.tankstats;


import hu.grofandriska.wotandme.api.model.player.personaldata.MetaDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class DetailedTankStatsWrapper {

    private String status;
    private MetaDTO meta;

    private Map<String, List<DetailedTankStatDTO>> data;
}
