package com.ArcomTech.ApiV1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationDto {
    private Integer idContact;
    @NotBlank
    private String mail;
    private String password;
}
