package CommonServices;

import com.example.ZomatoEurekaClient.Model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionResponse {
    private Dominoes dominoes;
    private Payment payment;
    private String message;

}
