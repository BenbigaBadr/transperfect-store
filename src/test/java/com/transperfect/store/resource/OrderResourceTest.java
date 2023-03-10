package com.transperfect.store.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transperfect.store.consts.ApiPath;
import com.transperfect.store.exception.TechnicalException;
import com.transperfect.store.resource.payload.UpdateStatusReq;
import com.transperfect.store.type.OrderStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext
@ActiveProfiles("test")
public class OrderResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOrderDetails() throws Exception {
        UpdateStatusReq request = new UpdateStatusReq(OrderStatus.DELIVERED);
        mockMvc.perform(MockMvcRequestBuilders.put(ApiPath.ORDERS + ApiPath.ORDER_STATUS, 2).contentType(MediaType.APPLICATION_JSON).content(asJson(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(OrderStatus.DELIVERED.name())));
    }

    @Test
    public void shouldReturnOrderNotFoundException() throws Exception {
        long notExistingOrderId = 9999;
        UpdateStatusReq request = new UpdateStatusReq(OrderStatus.DELIVERED);
        mockMvc.perform(MockMvcRequestBuilders.put(ApiPath.ORDERS + ApiPath.ORDER_STATUS, notExistingOrderId).contentType(MediaType.APPLICATION_JSON).content(asJson(request)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Order with Id "+notExistingOrderId+" is not found")));
    }

    private String asJson(Object object) throws TechnicalException {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
    }
}
