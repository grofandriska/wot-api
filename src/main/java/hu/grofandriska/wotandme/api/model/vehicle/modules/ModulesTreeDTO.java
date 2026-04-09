package hu.grofandriska.wotandme.api.model.vehicle.modules;

import java.util.List;

public class ModulesTreeDTO {
    public Boolean is_default;
    public Integer module_id;
    public String name;
    public List<Integer> next_modules;
    public List<Integer> next_tanks;
    public Integer price_credit;
    public Integer price_xp;
    public String type;
}
