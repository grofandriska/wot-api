package hu.grofandriska.wotandme.api.model.vehicle;

import hu.grofandriska.wotandme.api.model.vehicle.modules.ImagesDTO;
import hu.grofandriska.wotandme.api.model.vehicle.modules.ModulesTreeDTO;
import hu.grofandriska.wotandme.api.model.vehicle.tankdetail.CrewDTO;
import hu.grofandriska.wotandme.api.model.vehicle.tankdetail.DefaultProfileDTO;
import hu.grofandriska.wotandme.api.model.vehicle.tankdetail.MultinationDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class VehiclesDetailDTO {
    //Details
    public String tag;
    public Integer tank_id;
    public String nation;
    public String name;
    public String short_name;
    public Integer tier;
    public String type;
    public String description;
    public DefaultProfileDTO default_profile;
    public Map<String, ModulesTreeDTO> modules_tree;
    public Map<String, Integer> next_tanks;

    //booleans
    public Boolean is_gift;
    public Boolean is_premium;
    public Boolean is_premium_igr;
    public Boolean is_wheeled;

    //prices
    public Integer price_credit;
    public Integer price_gold;
    public Map<String, Integer> prices_xp;

    //Modules
    public List<Integer> engines;
    public List<Integer> guns;
    public List<Integer> provisions;
    public List<Integer> radios;
    public List<Integer> suspensions;
    public List<Integer> turrets;

    //crew and roles
    public List<CrewDTO> crew;

    //Misc
    public ImagesDTO images;
    public MultinationDTO multination;
}
