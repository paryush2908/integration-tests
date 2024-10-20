package com.example.integrationtests;

import com.example.integrationtests.apiClient.LoyaltyClient;
import com.example.integrationtests.apiClient.NotificationClient;
import com.example.integrationtests.db.OrderRepository;
import com.example.integrationtests.model.Order;
import com.example.integrationtests.model.OrderDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationClient notificationClient;
    private final LoyaltyClient loyaltyClient;

    public OrderService(
            OrderRepository orderRepository,
            NotificationClient notificationClient,
            LoyaltyClient loyaltyClient
    ) {
        this.orderRepository = orderRepository;
        this.notificationClient = notificationClient;
        this.loyaltyClient = loyaltyClient;
    }

    public void placeOrder(OrderDTO orderDTO) {
        String orderNumber = generateOrderNumber();
        Order order = new Order(
                orderDTO.getCustomerId(),
                orderNumber,
                "CONFIRMED",
                orderDTO.getAmount(),
                LocalDateTime.now()
                );
        orderRepository.save(order);
        notificationClient.sendOrderNotification(order);
        loyaltyClient.addLoyalty(order);
    }

    private String generateOrderNumber() {
        Random random = new Random();

        // Generate first 3 capital letters (A-Z)
        String letters = IntStream.range(0, 3)
                .mapToObj(i -> "" + (char) ('A' + random.nextInt(26)))
                .collect(Collectors.joining());

        // Generate last 3 digits (0-9)
        String digits = IntStream.range(0, 3)
                .mapToObj(i -> "" + random.nextInt(10))
                .collect(Collectors.joining());

        //orderNumbers like ORD_ABC123
        return "ORD_" + letters + digits;
    }
}
