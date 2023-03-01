package com.transperfect.store.domain;

import com.transperfect.store.service.OrderService;
import com.transperfect.store.type.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy= "order")
    private List<OrderItem> items;
}
