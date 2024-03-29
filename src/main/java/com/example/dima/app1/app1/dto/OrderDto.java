package com.example.dima.app1.app1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    private long id;
    private String name;
    private String price;
    private String orderPhotoUrl;
}
