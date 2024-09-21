package thundermarket.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "CheckStock_table")
@Data
public class CheckStock {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long productId;
    private Integer qty;
    private String productName;
    private Long orderId;
    private Long orderId;
}
