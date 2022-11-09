package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.mapping.IllnessMapper;
import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.IllnessService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessServiceImpl implements IllnessService {

    private final IllnessMapper illnessMapper;

    public IllnessServiceImpl(IllnessMapper illnessMapper) {
        this.illnessMapper = illnessMapper;
    }

    @Override
    public List<Illness> getAllIllnesses() {
        return illnessMapper.getAllIllnesses();
    }

    @Override
    public int createIllness(Illness illness) {
        MedicalCard card = illnessMapper.findCardById(illness.getMedicalCardId());
        if (card == null) return 1;
        else {
            illness.setId(illnessMapper.count() + 1);
            illnessMapper.createIllness(illness);
            return 0;
        }
    }
}
