package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class RapidDTO {
    public Integer speed_backward;
    public Integer speed_forward;
    public Integer suspension_steering_lock_angle;
    public Float switch_off_time;
    public Float switch_on_time;
}
