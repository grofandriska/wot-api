package hu.grofandriska.wotandme.api.service;


import hu.grofandriska.wotandme.api.model.vehicle.VehicleDetailsWrapperDTO;
import hu.grofandriska.wotandme.api.model.vehicle.VehiclesDetailDTO;
import hu.grofandriska.wotandme.api.model.vehicle.WargamingResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VehicleDetailsService {

    private final WebClient webClient;
    @Value("${app.id}")
    private String appId;

    public VehicleDetailsService(WebClient webClient) {
        this.webClient = webClient;
    }

    public WargamingResponseDTO<VehiclesDetailDTO> getAllVehicle() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/wot/encyclopedia/vehicles/")
                        .queryParam("application_id", appId)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<WargamingResponseDTO<VehiclesDetailDTO>>() {
                })
                .block();
    }


    public WargamingResponseDTO<VehicleDetailsWrapperDTO> getVehicleDetails(Integer tank_id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/wot/encyclopedia/vehicleprofile/")
                        .queryParam("application_id", appId)
                        .queryParam("tank_id", tank_id)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference <WargamingResponseDTO<VehicleDetailsWrapperDTO>>() {
                })
                .block();
    }
}
