
package rs.ac.uns.zuul.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ad")
public interface AdClient {

    @GetMapping("/ad/{id}")
    List<?> getAdById(@PathVariable("id") Long id) ;
	


}
