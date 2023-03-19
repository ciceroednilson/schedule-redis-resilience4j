package br.com.ciceroednilson.repository;

import br.com.ciceroednilson.repository.entities.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleRestRepository {

    @Autowired(required = true)
    private RestTemplate restTemplate;

    @Value("${integration.url-car-search}")
    private String urlCarSearch;

    public List<VehicleEntity> findAll() {
       final ResponseEntity<VehicleEntity[]> response = this.restTemplate.getForEntity(urlCarSearch, VehicleEntity[].class);
        return Arrays.stream(response.getBody()).toList();
    }
}
