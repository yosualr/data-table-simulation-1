package com.simulation.testdatatable.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequestDTO {
    private String customerName;
    private String customerCity;
}
