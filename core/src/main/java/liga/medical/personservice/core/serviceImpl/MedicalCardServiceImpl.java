package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.mapping.MedicalCardMapper;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardMapper medicalCardMapper;

    public MedicalCardServiceImpl(MedicalCardMapper medicalCardMapper) {
        this.medicalCardMapper = medicalCardMapper;
    }

    @Override
    public List<MedicalCard> getAllMedCards() {
        return medicalCardMapper.getAllMedCards();
    }
}
