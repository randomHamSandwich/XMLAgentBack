package rs.ac.uns.zuul.dto;

import java.util.List;

public class RestaurantDTO {

    private Long id;
    private String name;
    private List<OrderResponseDTO> orders;

    public RestaurantDTO() {}

    public RestaurantDTO(Long id,
                         String name) {
        this.id = id;
        this.name = name;
    }

    public RestaurantDTO(Long id,
                         String name,
                         List<OrderResponseDTO> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderResponseDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderResponseDTO> orders) {
        this.orders = orders;
    }
}
