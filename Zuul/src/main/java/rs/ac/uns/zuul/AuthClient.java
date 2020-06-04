package rs.ac.uns.zuul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consumer")
public interface AuthClient {

    @GetMapping("/verify/{email}")
    boolean verify(@PathVariable("email") String email);

}
