package rs.ac.uns.zuul.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderResponseDTO {

    private Long id;
    private Long restaurantId;
    private Long consumerId;
    private OrderStatus orderStatus;
    private List<OrderLineItemDTO> items;

    public OrderResponseDTO() {
        this.items = new ArrayList<>();
    }

    public OrderResponseDTO(
            Long id,
            Long restaurantId,
            Long consumerId,
            OrderStatus orderStatus,
            List<OrderLineItemDTO> items) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.consumerId = consumerId;
        this.orderStatus = orderStatus;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderLineItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderLineItemDTO> items) {
        this.items = items;
    }
}
