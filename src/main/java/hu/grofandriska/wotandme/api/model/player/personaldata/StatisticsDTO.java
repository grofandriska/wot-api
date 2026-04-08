package hu.grofandriska.wotandme.api.model.player.personaldata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatisticsDTO {
    private StatisticsDetailDTO all;
    private StatisticsDetailDTO clan;
    @JsonProperty("regular_team")
    private StatisticsDetailDTO regularTeam;
    private StatisticsDetailDTO company;
    @JsonProperty("stronghold_skirmish")
    private StatisticsDetailDTO strongholdSkirmish;
    @JsonProperty("stronghold_defense")
    private StatisticsDetailDTO strongholdDefense;
    private StatisticsDetailDTO historical;
    private StatisticsDetailDTO team;
    @JsonProperty("trees_cut")
    private Integer treesCut;
    private Integer frags;
}
