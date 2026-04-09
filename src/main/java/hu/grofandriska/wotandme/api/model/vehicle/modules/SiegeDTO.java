package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class SiegeDTO {
    public Float aim_time;
    public Float dispersion;
    public Integer move_down_arc;
    public Integer move_up_arc;
    public Float reload_time;
    public Integer speed_backward;
    public Integer suspension_traverse_speed;
    public Float switch_off_time;
    public Float switch_on_time;
}
