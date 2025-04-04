package org.example.emp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Manager {

    @Id
    private Long managerId;

    private String managerName;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
//    @JsonBackReference
    private List<Employee> employeeList;

}
