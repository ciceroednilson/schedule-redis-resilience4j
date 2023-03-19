package br.com.ciceroednilson.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Response {

    private String origen;
    private List<Vehicle> vehicles;
}
