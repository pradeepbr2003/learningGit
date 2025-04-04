package org.example.emp.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ManagerDTO {
    private Long managerId;
    private String managerName;
}
