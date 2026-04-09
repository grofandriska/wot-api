package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class TurretDTO {
    public Integer hp;
    public String name;
    public String tag;
    public Integer tier;
    public Integer traverse_left_arc;
    public Integer traverse_right_arc;
    public Integer traverse_speed;
    public Integer view_range;
    public Integer weight;
}
