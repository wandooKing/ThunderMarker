package thundermarket.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import thundermarket.DeliveryApplication;
import thundermarket.domain.DeliveryFailed;
import thundermarket.domain.DeliveryStarted;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer qty;

    private Long orderId;

    private String address;

    private String status;

    private Long productId;

    @PostPersist
    public void onPostPersist() {
        // DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        // deliveryStarted.publishAfterCommit();

        // DeliveryFailed deliveryFailed = new DeliveryFailed(this);
        // deliveryFailed.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        //implement business logic here:

        Delivery delivery = new Delivery();
        delivery.setOrderId(orderPlaced.getId());
        delivery.setProductId(orderPlaced.getProductId());
        delivery.setProductName(orderPlaced.getProductName());
        delivery.setQty(orderPlaced.getQty());
        delivery.setStatus("DeliveryStarted");
        
        repository().save(delivery);
        
        DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
        deliveryStarted.publishAfterCommit();

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
            deliveryStarted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCanceld orderCanceld) {

        Delivery delivery = new Delivery();
        delivery.setOrderId(orderCanceld.getId());
        delivery.setProductId(orderCanceld.getProductId());
        delivery.setProductName(orderCanceld.getProductName());
        delivery.setQty(orderCanceld.getQty());

        if(orderCanceld.getStatus().equals("OutofStock")){
            delivery.setStatus("DeliveryCanceldbyOutofStock");
        }else{
            delivery.setStatus("DeliveryCanceldbyOrderCancel");
        }
        
        repository().save(delivery);
        
        DeliveryFailed deliveryFailed = new DeliveryFailed(delivery);
        deliveryFailed.publishAfterCommit();

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
