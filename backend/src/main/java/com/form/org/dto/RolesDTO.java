package com.form.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDTO {

    private Integer idRole;

    private String roleName;

    @JsonIgnore
    private EmployeDTO employe;

    public static RolesDTO fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDTO.builder()
                .idRole(roles.getIdRole())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDTO dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setIdRole(dto.getIdRole());
        roles.setRoleName(dto.getRoleName());
        roles.setEmploye(EmployeDTO.toEntity(dto.getEmploye()));
        return roles;
    }
}
