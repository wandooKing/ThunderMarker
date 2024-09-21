package thundermarket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import thundermarket.infra.AbstractEvent;

@Data
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;
}
