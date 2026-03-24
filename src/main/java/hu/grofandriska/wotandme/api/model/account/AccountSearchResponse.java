package hu.grofandriska.wotandme.api.model.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class AccountSearchResponse {
    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private List<AccountSearchResponseData> accountList;
}
