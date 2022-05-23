package com.example.relation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;




@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bookdto {

    private Integer id;
    @NotBlank(message = "Iltimos Muallifni Kiriting")
    @Size(min = 2,max = 50)
    private String author;
    @NotBlank(message = "Iltimos Sarlavhani kiriting")
    @Size(min = 3,max = 50)
    private String title;
    @NotBlank(message = "Iltimos narxini kiriting")
    @Size(min = 1,max = 2147483646)
    private Double price;
    private String bookImage;
    private Date publishedDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
