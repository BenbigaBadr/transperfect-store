package com.transperfect.store.resource.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transperfect.store.type.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStatusReq {
    private OrderStatus status;
}
