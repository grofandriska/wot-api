package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class ArmorDTO {
    public HullArmorDto hull;
    public TurretArmorDto turret;

    public static class HullArmorDto {
        public Integer front;
        public Integer rear;
        public Integer sides;
    }

    public static class TurretArmorDto {
        public Integer front;
        public Integer rear;
        public Integer sides;
    }
}
