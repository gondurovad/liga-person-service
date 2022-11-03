package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.service.IllnessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/personservice/illness")
@Api(value = "API для работы с заболеваниями")
public class IllnessController {

    private final IllnessService illnessService;

    public IllnessController(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получение всех заболеваний")
    public List<Illness> getAllIllnesses() {
        return illnessService.getAllIllnesses();
    }

    @PostMapping(path = "/create")
    @ApiOperation(value = "Регистрация нового заболевания")
    public ResponseEntity<String> createIllness(@RequestBody Illness illness) {
        if (illnessService.createIllness(illness) == 0)
            return new ResponseEntity<>("Illness was created.", HttpStatus.OK);
        else return new ResponseEntity<>("The medical card associated with the disease was not found.", HttpStatus.BAD_REQUEST);
    }
}
