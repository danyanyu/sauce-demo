package Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderInfo {

    String Name;
    String Country;
    String City;
    String CreditCard;
    String Month;
    String Year;
}
