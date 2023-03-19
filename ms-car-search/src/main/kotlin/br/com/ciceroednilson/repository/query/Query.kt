package br.com.ciceroednilson.repository.query

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory

class Query(val select: String) {

    companion object {
        fun builder(): Query {
            val text = javaClass.getResource("/query/vehicles.yaml").readText()
            val objectMapper = ObjectMapper(YAMLFactory())
            objectMapper.findAndRegisterModules()
            return objectMapper.readValue(text, Query::class.java)
        }
    }
}
