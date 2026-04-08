package hu.grofandriska.wotandme.api.model.player;

import lombok.Data;

import java.util.Map;

@Data
public class PlayerPersonalDataWrapper {

    private String status;
    private MetaDTO meta;
    private Map <String,PlayerPersonalData> data;
}
