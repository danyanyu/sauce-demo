package Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderInfo {

    public String Name;
    public String Country;
    public String City;
    public String CreditCard;
    public String Month;
    public String Year;

    public OrderInfo(String Name,
                     String Country,
                     String City,
                     String CreditCard,
                     String Month,
                     String Year){
        this.Name=Name;
        this.Country=Country;
        this.City=City;
        this.CreditCard=CreditCard;
        this.Month=Month;
        this.Year=Year;
    }
}
