package com.transperfect.store.service;

import com.transperfect.store.domain.Order;
import com.transperfect.store.dto.MailDTO;
import com.transperfect.store.dto.OrderDTO;
import com.transperfect.store.exception.BusinessException;
import com.transperfect.store.mapper.OrderMapper;
import com.transperfect.store.repository.OrderRepository;
import com.transperfect.store.resource.payload.UpdateStatusReq;
import com.transperfect.store.type.MailTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final MailService mailService;
    private final TemplateEngine templateEngine;

    @Transactional
    public OrderDTO updateStatus(UpdateStatusReq request, Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new BusinessException(String.format("Order with Id %s is not found", orderId), HttpStatus.NOT_FOUND));
        order.setStatus(request.getStatus());
        order = orderRepository.save(order);
        mailService.sendMail(buildUpdateStatusMail(order));
        return orderMapper.toDTO(order);
    }

    private MailDTO buildUpdateStatusMail(Order order)
    {
        String subject = "ORDER ".concat(order.getReference()).concat(" has been updated");
        Context context = new Context();
        context.setVariable("status", order.getStatus().name());
        context.setVariable("reference", order.getReference());
        return MailDTO.builder().from("from@gmail.com").to("to@gmail.com").subject(subject).message(templateEngine.generateHtml(MailTemplate.UPDATE_ORDER_STATUS.name(), context)).build();
    }
}
