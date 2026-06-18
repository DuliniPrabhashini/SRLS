package com.example.MyProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private long itemId;

    @NotBlank(message = "Item name is required !")
    private String itemName;

    @Positive(message = "Price must be positive !")
    private Double itemPrice;

    @PositiveOrZero(message = "Quantity cannot be negative !")
    private Integer itemQuantity;
}
