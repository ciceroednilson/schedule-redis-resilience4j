package br.com.ciceroednilson.repository

import br.com.ciceroednilson.repository.entities.VehicleEntity
import br.com.ciceroednilson.repository.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository


@Repository
class VehicleRepository(@Autowired var jdbcTemplate: JdbcTemplate) {

    fun findAll(): List<VehicleEntity> {
        val listVehicleEntity = ArrayList<VehicleEntity>()
        val list = this.jdbcTemplate.queryForList(Query.builder().select)
        list.forEach {
            val vehicle = VehicleEntity(it["id_brand"].toString().toInt(), it["brand"].toString(), it["id_model"].toString().toInt(), it["model"].toString())
            listVehicleEntity.add(vehicle)
        }
        return listVehicleEntity
    }
}