package liga.medical.personservice.core.serviceImpl;

import liga.medical.personservice.core.annotations.DBLog;
import liga.medical.personservice.core.service.RabbitConsumerService;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumerServiceImpl implements RabbitConsumerService {

    @DBLog
    @Override
    public void receiveMessage(String message) {
        System.out.println(String.format("Message [%s] received from queues to person-service.", message));
    }
}
