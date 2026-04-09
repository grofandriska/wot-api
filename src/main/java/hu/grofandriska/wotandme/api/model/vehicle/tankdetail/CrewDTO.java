package hu.grofandriska.wotandme.api.model.vehicle.tankdetail;

import lombok.Data;

import java.util.Map;


@Data
public class CrewDTO {
    public String member_id;
    public Map<String, String> roles; // Role ID -> Role Name/Description
}
