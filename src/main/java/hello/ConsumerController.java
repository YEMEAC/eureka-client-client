package hello;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/** @author Yeison Melo */
@RestController
@RequestMapping("/consume-service")
class ConsumerController {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired RestTemplate restTemplate = new RestTemplate();

  @GetMapping("/ping")
  public ResponseEntity<?> serviceInstancesByApplicationName() throws URISyntaxException {

    return restTemplate.exchange(
        new URI("http://microservice-service/ping"), HttpMethod.GET, null, Object.class);
  }
}
