package hu.grofandriska.wotandme.api.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AccountSearchResponseData {

    @JsonProperty("account_id")
    private Long id;
    @JsonProperty("nickname")
    private String nickname;
}
