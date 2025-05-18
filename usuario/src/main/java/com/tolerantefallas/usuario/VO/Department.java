package com.tolerantefallas.usuario.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long departmentId;
    private String privateName;
    private String departmentAddress;
    private String departmentCode;
}
