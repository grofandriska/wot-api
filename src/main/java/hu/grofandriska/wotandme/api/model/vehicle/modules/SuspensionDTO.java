package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class SuspensionDTO {
    public Integer load_limit;
    public String name;
    public Integer steering_lock_angle;
    public String tag;
    public Integer tier;
    public Integer traverse_speed;
    public Integer weight;
}
