package com.bankiapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long id;
    private String firstName;
    private  String lastName;
    private String email;
    private String telephone;
    private String birthday;
    private List<Long> groups_id;
}
