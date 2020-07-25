package rs.ac.uns.zuul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "aut-s")
public interface AuthClient {

	@GetMapping("/verify")
	boolean verify(String jwt);

//    @PostMapping("/verify")
//    boolean verify(HttpServletRequest request);

}
