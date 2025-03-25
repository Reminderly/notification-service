package br.com.reminderly.notification.consumer;

import br.com.reminderly.notification.dto.NotificationRecordDto;
import br.com.reminderly.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${broker.queue.notification.name}")
    public void listenSchedulerQueue(@Payload NotificationRecordDto notificationRecordDto){
        notificationService.sendEmail(notificationRecordDto);
    }
}