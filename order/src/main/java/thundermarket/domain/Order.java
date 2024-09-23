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
    
    
    
    
    private Integer price;

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
    
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }



    public void order(){
        //implement business logic here:
        
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
        
        
        thundermarket.external.CheckStockQuery checkStockQuery = new thundermarket.external.CheckStockQuery();
        OrderApplication.applicationContext
            .getBean(thundermarket.external.InventoryService.class)
            .checkStock( checkStockQuery);
    }
    public void cancel(){
        //implement business logic here:
        
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
        
        
        thundermarket.external.OrderQuery orderQuery = new thundermarket.external.OrderQuery();
        OrderApplication.applicationContext
            .getBean(thundermarket.external.Service.class)
            .( orderQuery);
    }

//<<< Clean Arch / Port Method
    public static void updateStatus(OutOfStock outOfStock){
        
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderCanceled orderCanceled = new OrderCanceled(order);
        orderCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(outOfStock.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderCanceled orderCanceled = new OrderCanceled(order);
            orderCanceled.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
