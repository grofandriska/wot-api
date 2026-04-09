package hu.grofandriska.wotandme.api.controller;

import hu.grofandriska.wotandme.api.model.vehicle.VehicleDetailsWrapperDTO;
import hu.grofandriska.wotandme.api.model.vehicle.VehiclesDetailDTO;
import hu.grofandriska.wotandme.api.model.vehicle.WargamingResponseDTO;
import hu.grofandriska.wotandme.api.service.VehicleDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wot/vehicle")
public class VehicleController {

    private VehicleDetailsService service;

    public VehicleController(VehicleDetailsService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<WargamingResponseDTO<VehiclesDetailDTO>> getAllVehicle(){
        return ResponseEntity.ok(service.getAllVehicle());
    }

    @GetMapping("/details")
    public ResponseEntity<WargamingResponseDTO<VehicleDetailsWrapperDTO>> getVehicleDetails(Integer tank_id){
        return ResponseEntity.ok(service.getVehicleDetails(tank_id));
    }
}
