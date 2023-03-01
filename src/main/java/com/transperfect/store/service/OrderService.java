package com.transperfect.store.service;

import com.transperfect.store.domain.Order;
import com.transperfect.store.dto.OrderDTO;
import com.transperfect.store.mapper.OrderMapper;
import com.transperfect.store.repository.OrderRepository;
import com.transperfect.store.resource.payload.UpdateStatusReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDTO updateStatus(UpdateStatusReq request, Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException(""));
        order.setStatus(request.getStatus());
        order = orderRepository.save(order);
        //TODO send notification in async
        return orderMapper.toDTO(order);
    }
}
