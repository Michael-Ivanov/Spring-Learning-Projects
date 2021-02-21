package miv.study.service;

import miv.study.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerRestService {

    private RestTemplate restTemplate;
    private String restUrl;

    @Autowired
    public CustomerRestService(RestTemplate restTemplate,
                               @Value("${crm.rest.url}") String restUrl) {
        this.restTemplate = restTemplate;
        this.restUrl = restUrl;
    }

    public List<Customer> getCustomers() {
        ResponseEntity<List<Customer>> responseEntity =
                restTemplate.exchange(
                        restUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Customer>>() {
                });
        return responseEntity.getBody();
    }
}
