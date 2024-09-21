package thundermarket.external;

import java.util.Date;
import lombok.Data;

@Data
public class Inventory {

    private Long id;
    private String productName;
    private Integer stock;
    private Date regDate;
    private Date expiredDate;
}
