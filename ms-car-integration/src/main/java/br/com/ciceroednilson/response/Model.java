package br.com.ciceroednilson.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Model {

    private int id;
    private String description;
}
