package liga.medical.personservice.core.serviceImpl;

import liga.medical.common.dto.QueueNames;
import liga.medical.personservice.core.service.RabbitConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitQueueListener {

    private final RabbitConsumerService rabbitConsumerService;

    public RabbitQueueListener(RabbitConsumerService rabbitConsumerService) {
        this.rabbitConsumerService = rabbitConsumerService;
    }

    @RabbitListener(queues = {QueueNames.DAILY_QUEUE_NAME, QueueNames.ALERT_QUEUE_NAME})
    public void receiveMessages(String message) {
        rabbitConsumerService.receiveMessage(message);
    }
}
