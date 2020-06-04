package rs.ac.uns.zuul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.zuul.client.KitchenClient;
import rs.ac.uns.zuul.client.OrderClient;
import rs.ac.uns.zuul.dto.OrderResponseDTO;
import rs.ac.uns.zuul.dto.RestaurantDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AggregationController {

    private KitchenClient kitchenClient;
    private OrderClient orderClient;

    @Autowired
    public AggregationController(KitchenClient kitchenClient,
                                 OrderClient orderClient) {
        this.kitchenClient = kitchenClient;
        this.orderClient = orderClient;
    }

    @GetMapping("/RestaurantsAndOrders")
    public ResponseEntity<?> getOrdersAndRestaurant(@RequestHeader("username") String username,
                                                    @RequestHeader("role") String role) {

        List<OrderResponseDTO> orders = this.orderClient.getOrders(username, role);
        List<RestaurantDTO> restaurants = this.kitchenClient.getRestaurants(username, role);
        for (RestaurantDTO restaurant : restaurants) {
            restaurant.setOrders(orders.stream().filter(o -> o.getRestaurantId().equals(restaurant.getId())).collect(Collectors.toList()));
        }

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
}
