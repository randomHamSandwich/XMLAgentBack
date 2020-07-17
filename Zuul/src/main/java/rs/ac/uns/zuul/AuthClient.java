package rs.ac.uns.zuul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "aut-s")
public interface AuthClient {

//    @GetMapping("/verify/{jwtToken}")
//    boolean verify(@PathVariable("jwtToken") String jwtToken);

}


