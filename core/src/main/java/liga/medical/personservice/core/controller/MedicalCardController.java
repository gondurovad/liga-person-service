package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personservice")
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping(path = "/medcards", produces = "application/json")
    public List<MedicalCard> getAllMedCards() {
        return medicalCardService.getAllMedCards();
    }
}
