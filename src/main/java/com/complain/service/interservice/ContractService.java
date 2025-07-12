package com.complain.service.interservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class ContractService {
    private WebClient webClient;

    public ContractService(WebClient.Builder builder, @Value("${service.contract.url}") String url){
        this.webClient=builder.baseUrl(url).build();
    }

    public Boolean CustomerContractExists(int id){
        try{
            webClient.head()
                    .uri("/customers/contracts/"+id)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            return true;
        } catch (WebClientResponseException.NotFound ex){
            return false;
        } catch (WebClientResponseException ex){
            throw new RuntimeException("Unexpected error", ex);
        }
    }
}
