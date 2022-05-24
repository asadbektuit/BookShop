package com.example.relation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @NotBlank(message = ("Togri kirit ***"))
    private String password;
    @NotBlank(message = ("Togri kirit ***"))
    @Size(min = 12, max = 13)
    private String contact;
    private Boolean city;
    @Email
    private Integer email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
