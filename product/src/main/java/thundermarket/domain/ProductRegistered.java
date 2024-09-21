package thundermarket.domain;

import java.util.*;
import lombok.*;
import thundermarket.domain.*;
import thundermarket.infra.AbstractEvent;

@Data
@ToString
public class ProductRegistered extends AbstractEvent {

    private Long id;
}
