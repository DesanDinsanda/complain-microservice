package com.complain.Service.Interservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class CustomerService {
    private WebClient webClient;

    public CustomerService(WebClient.Builder builder, @Value("${service.customer.url}") String url){
        this.webClient = builder.baseUrl(url).build();
    }

    public Boolean CustomerExists(int id){
        try{
            webClient.head()
                    .uri("/customers/"+id)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            return true;
        } catch(WebClientResponseException.NotFound ex){
            return false;
        } catch (Exception ex){
            throw new RuntimeException("Unknown error", ex);
        }
    }
}
