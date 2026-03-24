package hu.grofandriska.wotandme.api.model.player;

public class PlayerPersonalData {

    /*
    * created_at	timestamp
    * logout_at	timestamp
    * global_rating	numeric
    * nickname	string
    * updated_at	timestamp
    * ---- Is Banned ------
    * private.ban_info	string
    * Account ban details
    * private.ban_time	timestamp
    * End time of account
    *------------------------
    *private.restrictions.chat_ban_time	timestamp End time of chat ban
    *
    * statistic    player statistics
    * statistics.frags	associative array	Number and models of vehicles destroyed by a player. Player's private data.
    * statistics.trees_cut	numeric	Trees knocked down
    *statistics.all
Total statistics in Random and clan battles without the Global Map 2.0 statistics

statistics.all.avg_damage_assisted	float
Average damage caused with your assistance. Value is calculated starting from version 8.8.

statistics.all.avg_damage_assisted_radio	float
Average damage upon your spotting. Value is calculated starting from version 8.8.

statistics.all.avg_damage_assisted_stun	float
Average assisted stun damage.

statistics.all.avg_damage_assisted_track	float
Average damage upon your shooting the track. Value is calculated starting from version 8.8.

statistics.all.avg_damage_blocked	float
Average damage blocked by armor per battle. Damage blocked by armor is damage received from shells (AP, HEAT and APCR) that hit a vehicle but caused no damage. Value is calculated starting from version 9.0.

statistics.all.battle_avg_xp	numeric
Average experience per battle

statistics.all.battles	numeric
Battles fought

statistics.all.battles_on_stunning_vehicles	numeric
Number of battles on vehicles that cause the stun effect

statistics.all.capture_points	numeric
Base capture points

statistics.all.damage_dealt	numeric
Damage caused

statistics.all.damage_received	numeric
Damage received

statistics.all.direct_hits_received	numeric
Direct hits received

statistics.all.draws	numeric
Draws

statistics.all.dropped_capture_points	numeric
Base defense points

statistics.all.explosion_hits	numeric
Hits on enemy as a result of splash damage

statistics.all.explosion_hits_received	numeric
Hits received as a result of splash damage

statistics.all.frags	numeric
Vehicles destroyed

statistics.all.hits	numeric
Hits

statistics.all.hits_percents	numeric
Hit ratio

statistics.all.losses	numeric
Defeats

statistics.all.max_damage	numeric
Maximum damage caused in a battle

statistics.all.max_damage_tank_id	numeric
Vehicle used to cause maximum damage

statistics.all.max_frags	numeric
Maximum destroyed in battle

statistics.all.max_frags_tank_id	numeric
Vehicle, in which maximum number of enemy vehicles was destroyed

statistics.all.max_xp	numeric
Maximum experience per battle

statistics.all.max_xp_tank_id	numeric
Vehicle used to gain maximum experience per battle

statistics.all.no_damage_direct_hits_received	numeric
Direct hits received that caused no damage

statistics.all.piercings	numeric
Penetrations

statistics.all.piercings_received	numeric
Penetrations received

statistics.all.radio_assisted_damage	numeric
Damage dealt to the target with the actor radio recon assistance

statistics.all.shots	numeric
Shots fired

statistics.all.spotted	numeric
Enemies spotted

statistics.all.stun_assisted_damage	numeric
Damage to enemy vehicles stunned by you

statistics.all.stun_number	numeric
Number of times an enemy was stunned by you

statistics.all.survived_battles	numeric
Battles survived

statistics.all.tanking_factor	float
Ratio of damage blocked by armor from AP, HEAT, and APCR shells to damage received from these types of shells. Value is calculated starting from version 9.0.

statistics.all.track_assisted_damage	numeric
Damage dealt to the target with the actor keeping-on-track assistance

statistics.all.wins	numeric
Victories

statistics.all.xp	numeric
Total experience
    *
    * */
}
