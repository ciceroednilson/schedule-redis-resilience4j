package br.com.ciceroednilson.service;

import br.com.ciceroednilson.repository.entities.VehicleEntity;
import br.com.ciceroednilson.repository.redis.VehicleRedisRepository;
import br.com.ciceroednilson.repository.rest.VehicleRestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VehicleService {

    @Autowired
    private VehicleRedisRepository vehicleRedisRepository;

    @Autowired
    private VehicleRestRepository vehicleRestRepository;

    public void migration() {
        try {
            log.info("Searching list of vehicles");
            final List<VehicleEntity> vehiclesEntity = this.vehicleRestRepository.findAll();
            log.info("vehicles found " + vehiclesEntity.size());
            vehicleRedisRepository.saveAll(vehiclesEntity);
            log.info("Vehicles saved on data base");
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
}
