package org.example.actuator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import java.io.Serializable;
import java.util.List;

@JsonComponent
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActuatorLink implements Serializable {
    List<ActuatorTemplate> _links;
}
