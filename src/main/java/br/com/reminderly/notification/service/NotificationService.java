package br.com.reminderly.notification.service;

import br.com.reminderly.notification.dto.NotificationRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender emailSender;

    @Value("$spring.mail.username")
    private String emailFrom;

    public void sendEmail(NotificationRecordDto notificationRecordDto){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notificationRecordDto.sendingTo());
        message.setSubject(notificationRecordDto.title());
        message.setText(notificationRecordDto.message());
        emailSender.send(message);

    }
}
