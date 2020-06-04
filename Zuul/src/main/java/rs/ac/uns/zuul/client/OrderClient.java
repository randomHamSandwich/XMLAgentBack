package rs.ac.uns.zuul.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import rs.ac.uns.zuul.dto.OrderResponseDTO;

import java.util.List;

@FeignClient(name = "order")
public interface OrderClient {

    @GetMapping("/getAll")
    List<OrderResponseDTO> getOrders(@RequestHeader("username") String email,
                                     @RequestHeader("role") String role);
}
