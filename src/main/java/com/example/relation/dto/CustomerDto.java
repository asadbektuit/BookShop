package com.example.relation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {
    private Integer id;
    @NotBlank(message = ("Ismda xatolik"))
    private String name;
    @NotBlank(message = ("Familiyada xatolik"))
    private String surname;
    @NotBlank(message = ("Ismda xatolik"))
    private String password;
    private String contact;
    private Boolean city;
    private Integer email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
