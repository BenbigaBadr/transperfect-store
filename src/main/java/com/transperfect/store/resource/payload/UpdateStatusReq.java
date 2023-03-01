package com.transperfect.store.resource.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transperfect.store.type.OrderStatus;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateStatusReq {
    private OrderStatus status;
}
