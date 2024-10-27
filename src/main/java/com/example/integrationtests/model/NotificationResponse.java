package com.example.integrationtests.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NotificationResponse {
  private Long id;
  private Long customerId;
  private String orderNumber;
  private String message;
  private LocalDateTime createdAt;
}
