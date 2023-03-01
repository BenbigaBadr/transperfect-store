package com.transperfect.store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailDTO {

    @NotBlank(message = "Source email should not be empty or null!")
    @Email(message = "Invalid source email address")
    private String from;

    @NotBlank(message = "Destination emails should not be empty or null!")
    private String to;

    @NotBlank(message = "subject of the email should not be empty or null!")
    private String subject;

    @NotBlank(message = "body message of the email should not be empty or null!")
    private String message;

    private String ccp;
}
