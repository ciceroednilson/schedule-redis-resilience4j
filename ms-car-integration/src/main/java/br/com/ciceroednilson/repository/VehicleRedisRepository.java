package br.com.ciceroednilson.repository;

import br.com.ciceroednilson.repository.entities.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRedisRepository extends CrudRepository<VehicleEntity, Integer> {
}
