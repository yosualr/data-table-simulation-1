package com.simulation.testdatatable.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestDTO {
    private Long customerId;
    private String customerName;
    private String customerCity;
}
