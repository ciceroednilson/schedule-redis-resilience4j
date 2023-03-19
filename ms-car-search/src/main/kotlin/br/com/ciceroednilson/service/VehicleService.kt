package br.com.ciceroednilson.service

import br.com.ciceroednilson.repository.VehicleRepository
import br.com.ciceroednilson.repository.entities.VehicleEntity
import br.com.ciceroednilson.response.Model
import br.com.ciceroednilson.response.Vehicle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleService(@Autowired var vehicleRepository: VehicleRepository) {

    fun findAll(): List<Vehicle> {
        val listVehicleEntity = this.vehicleRepository.findAll()
        val vehiclesEntity = distinct(listVehicleEntity)
        val vehicles = ArrayList<Vehicle>()
        vehiclesEntity.forEach {
            vehicles.add(Vehicle(it.first, it.second, findAllModelOfBrand(it.first, listVehicleEntity)))
        }
        return vehicles
    }

    private fun distinct(listVehicleEntity: List<VehicleEntity>): List<Pair<Int, String>> {
        return listVehicleEntity
                .distinctBy { Pair(it.idBrand, it.brand) }
                .map { Pair(it.idBrand, it.brand) }
    }

    private fun findAllModelOfBrand(brand: Int, listVehicleEntity: List<VehicleEntity>): List<Model> {
        val models = ArrayList<Model>()
        listVehicleEntity.filter { it.idBrand == brand }.forEach {
            models.add(Model(it.idModel, it.model))
        }
        return models
    }
}