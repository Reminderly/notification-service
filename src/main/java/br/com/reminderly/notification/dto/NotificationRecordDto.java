package br.com.reminderly.notification.dto;

import java.time.Instant;
import java.util.UUID;

public record NotificationRecordDto(UUID id, String message, String title, String sendingTo,
                                    String notificationType, Instant reminderTime) {
}
