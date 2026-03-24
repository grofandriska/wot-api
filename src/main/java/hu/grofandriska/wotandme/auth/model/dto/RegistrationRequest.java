package hu.grofandriska.wotandme.auth.model.dto;


public record RegistrationRequest(String email, String password, String nickname) {
}
