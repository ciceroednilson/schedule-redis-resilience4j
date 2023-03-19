package br.com.ciceroednilson.controller;

import br.com.ciceroednilson.response.Vehicle;
import br.com.ciceroednilson.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<Vehicle>> all() {
        var list = this.vehicleService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
