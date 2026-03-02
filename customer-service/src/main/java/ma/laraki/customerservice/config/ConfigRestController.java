package ma.laraki.customerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigRestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
@Autowired
    private CustomerConfigParams customerConfigParams;
    @GetMapping("/config/global")
    public Map<String,String> ConfigGlobalParams(){
        return Map.of("P1",p1,"P2",p2);
    }

    @GetMapping("/config/params")
    public CustomerConfigParams getCustomerConfigParams(){
        return customerConfigParams;
    }
}
