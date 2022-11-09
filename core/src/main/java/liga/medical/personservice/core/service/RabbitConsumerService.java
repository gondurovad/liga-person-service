package liga.medical.personservice.core.service;

public interface RabbitConsumerService {

    void receiveMessage(String message);
}
