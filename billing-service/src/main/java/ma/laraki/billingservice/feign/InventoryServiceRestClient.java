package ma.laraki.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.laraki.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inventory-service",fallbackMethod = "getDefaultProductById")
    Product getProductById(@PathVariable long id);

    default Product getDefaultProductById(long id,Exception e){
        e.printStackTrace();
        System.out.println("Product service is down! Using fallback...");
        return Product.builder().id(id).build();
    }
}
