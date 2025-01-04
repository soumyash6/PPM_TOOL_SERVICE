package io.agileintelligence.ppmtool.controller.eureka;

import io.agileintelligence.ppmtool.model.CarPart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eureka")
public class CarPartController {

    @GetMapping("/carparts")
    public List<CarPart> getCarParts(@RequestParam(value = "model", required = false) String model) {
        CarPart engine = new CarPart();
        engine.setName("Engine");
        engine.setManufacturer("toyota");
        engine.setPartNumber("ENG123");

        CarPart tire = new CarPart();
        tire.setName("Tire");
        tire.setManufacturer("Manufacturer B");
        tire.setPartNumber("TIR456");

        List<CarPart> carParts = Arrays.asList(engine, tire);

        if (model != null) {
            // Filter car parts based on the model parameter
            return carParts.stream()
                    .filter(part -> part.getManufacturer().equalsIgnoreCase(model))
                    .collect(Collectors.toList());
        }

        return carParts;
    }
}