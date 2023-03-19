package br.com.ciceroednilson.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Vehicle {

    private int id;
    private String description;
    private List<Model> models;
}
