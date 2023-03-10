package com.transperfect.store.resource;

import com.transperfect.store.consts.ApiPath;
import com.transperfect.store.dto.OrderDTO;
import com.transperfect.store.resource.payload.UpdateStatusReq;
import com.transperfect.store.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPath.ORDERS)
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @PutMapping(value = ApiPath.ORDER_STATUS)
    @ResponseStatus(HttpStatus.OK)
    OrderDTO updateStatus(@RequestBody @Valid UpdateStatusReq request, @PathVariable(name = "orderId") Long orderId)
    {
        return orderService.updateStatus(request, orderId);
    }
}
