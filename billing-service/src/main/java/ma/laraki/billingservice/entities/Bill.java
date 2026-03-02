package ma.laraki.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.laraki.billingservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id @GeneratedValue
    private long id;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;

}
