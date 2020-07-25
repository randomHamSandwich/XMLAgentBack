package rs.ac.uns.zuul;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "aut-s")
public interface AuthClient {

	@GetMapping("/verify")
	ArrayList<String> verify(String jwt);

//	@GetMapping("/verify")
//	String verify(String jwt);
//	

//    @PostMapping("/verify")
//    boolean verify(HttpServletRequest request);

}
