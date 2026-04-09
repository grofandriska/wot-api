package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class GunDTO {
    public Float aim_time;
    public Integer caliber;
    public Float dispersion;
    public Float fire_rate;
    public Integer move_down_arc;
    public Integer move_up_arc;
    public String name;
    public Float reload_time;
    public String tag;
    public Integer tier;
    public Integer traverse_speed;
    public Integer weight;
}
