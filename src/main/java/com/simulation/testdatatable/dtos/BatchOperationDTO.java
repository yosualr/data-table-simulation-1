package com.simulation.testdatatable.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchOperationDTO {
    private List<CreateRequestDTO> createRequests;
    private List<UpdateRequestDTO> updateRequests;
    private List<Long> deleteRequests;

}
