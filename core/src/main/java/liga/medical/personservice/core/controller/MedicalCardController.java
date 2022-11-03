package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personservice/medcard")
@Api(value = "API для работы с медицинскими картами клиентов")
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    @ApiOperation(value = "Получение всех медицинских карт")
    public List<MedicalCard> getAllMedCards() {
        return medicalCardService.getAllMedCards();
    }
}
