package br.com.ciceroednilson.repository.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RedisHash("vehicle")
public class VehicleEntity implements Serializable {

    private int id;
    private String description;
    private List<Model> models;
}
