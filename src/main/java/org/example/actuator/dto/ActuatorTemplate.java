package org.example.actuator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import java.io.Serializable;

@JsonComponent
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActuatorTemplate implements Serializable {
    private String href;
    private boolean templated;
}
