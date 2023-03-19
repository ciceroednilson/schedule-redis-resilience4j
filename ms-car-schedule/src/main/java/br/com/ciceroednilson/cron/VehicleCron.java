package br.com.ciceroednilson.cron;

import br.com.ciceroednilson.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class VehicleCron {

    @Autowired
    private VehicleService vehicleService;

    @Scheduled(cron = "*/5 * * * * ?")
    public void start() {
        log.info("Start Cron: " + new Date());
        vehicleService.migration();
        log.info("Finish Cron: " + new Date());
    }
}
