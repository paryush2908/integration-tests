package com.example.orderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.orderService.model.OrderDTO;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderRequest) {
    orderService.placeOrder(orderRequest);
    String responseMessage = "Order placed!";
    return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
  }
}