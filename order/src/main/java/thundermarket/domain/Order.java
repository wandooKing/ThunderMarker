package thundermarket.domain;

import thundermarket.domain.OrderPlaced;
import thundermarket.domain.OrderCanceled;
import thundermarket.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Order_table")
@Data

//<<< DDD / Aggregate Root
public class Order  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String productName;
    
    private Integer qty;
    
    private String status;
    
    private String customerId;
    
    private String customerName;
    
    private Long productId;

    @PostPersist
    public void onPostPersist(){
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    
    }

    @PreUpdate
    public void onPreUpdate(){
        OrderCanceld orderCanceld = new OrderCanceld(this);
        orderCanceld.setStatus("OutofStock");
        orderCanceld.publishAfterCommit(); 
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }


    public void order(){
        //implement business logic here:
        
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
  
    }
    public void cancel(){
        //implement business logic here:
        
        OrderCanceld orderCanceld = new OrderCanceld(this);
        orderCanceld.publishAfterCommit();
 
    }

//<<< Clean Arch / Port Method
public static void updateStatus(OutOfStock outOfStock) {
    repository().findById(outOfStock.getOrderId()).ifPresent(order ->{
        order.setStatus("OrderCancelled");
        repository().save(order);      
    });

    

    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
