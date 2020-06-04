package rs.ac.uns.zuul.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import rs.ac.uns.zuul.dto.RestaurantDTO;

import java.util.List;

@FeignClient(name = "kitchen")
public interface KitchenClient {

    @GetMapping("/getAllRestaurants")
    List<RestaurantDTO> getRestaurants(@RequestHeader("username") String email,
                                       @RequestHeader("role") String role);
}
