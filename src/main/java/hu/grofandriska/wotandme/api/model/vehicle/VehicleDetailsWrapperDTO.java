package hu.grofandriska.wotandme.api.model.vehicle;

import hu.grofandriska.wotandme.api.model.vehicle.modules.*;

import lombok.Data;

import java.util.List;
@Data
public class VehicleDetailsWrapperDTO {
    public Integer hp;
    public Integer hull_hp;
    public Integer hull_weight;
    public Boolean is_default;
    public Integer max_ammo;
    public Integer max_weight;
    public String profile_id;
    public Integer speed_backward;
    public Integer speed_forward;
    public Integer tank_id;
    public Integer weight;

    public List<AmmoDTO> ammo;
    public ArmorDTO armor;
    public EngineDTO engine;
    public GunDTO gun;
    public ModulesDTO modules;
    public RadioDTO radio;
    public RapidDTO rapid;
    public SiegeDTO siege;
    public SuspensionDTO suspension;
    public TurretDTO turret;
}