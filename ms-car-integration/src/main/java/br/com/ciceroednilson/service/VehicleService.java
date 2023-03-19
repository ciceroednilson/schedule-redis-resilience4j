package br.com.ciceroednilson.service;

import br.com.ciceroednilson.repository.VehicleRedisRepository;
import br.com.ciceroednilson.repository.VehicleRestRepository;
import br.com.ciceroednilson.repository.entities.VehicleEntity;
import br.com.ciceroednilson.response.Model;
import br.com.ciceroednilson.response.Response;
import br.com.ciceroednilson.response.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRedisRepository vehicleRedisRepository;

    @Autowired
    private VehicleRestRepository vehicleRestRepository;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    public Response findAll() {
        final CircuitBreaker circuitBreaker = circuitBreakerFactory.create("vehicle");
        return circuitBreaker.run(this::findAllRedis, throwable -> findAllRest());
    }

    private Response findAllRest() {
        final List<VehicleEntity> listEntity = vehicleRestRepository.findAll();
        final List<Vehicle> listVehicle = new ArrayList<>();
        listEntity.forEach(vehicleEntity -> {
            listVehicle.add(buildVehicle(vehicleEntity));
        });
        listVehicle.sort(Comparator.comparing(Vehicle::getDescription));
        return Response
                .builder()
                .origen("REST")
                .vehicles(listVehicle)
                .build();
    }

    private Response findAllRedis() {

        final List<Vehicle> listVehicle = new ArrayList<>();
        final Iterable<VehicleEntity> listEntity = vehicleRedisRepository.findAll();
        listEntity.forEach(vehicleEntity -> {
            listVehicle.add(buildVehicle(vehicleEntity));
        });
        listVehicle.sort(Comparator.comparing(Vehicle::getDescription));
        return Response
                .builder()
                .origen("REDIS")
                .vehicles(listVehicle)
                .build();

    }

    private Vehicle buildVehicle(final VehicleEntity vehicleEntity) {
        final List<Model> models = new ArrayList<>();
        vehicleEntity.getModels().forEach(modelEntity -> {
            final Model model = buildModel(modelEntity);
            models.add(model);
        });
        models.sort(Comparator.comparing(Model::getDescription));
        return Vehicle
                .builder()
                .id(vehicleEntity.getId())
                .description(vehicleEntity.getDescription())
                .models(models)
                .build();
    }

    private Model buildModel(final br.com.ciceroednilson.repository.entities.Model modelEntity) {
        return Model
                .builder()
                .id(modelEntity.getId())
                .description(modelEntity.getDescription())
                .build();
    }
}
