package CommonServices;

import com.example.ZomatoEurekaClient.Model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private Dominoes dominoes;
        private Payment payment;
}
