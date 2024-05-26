package com.bankiapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String firstName;
    private  String lastName;
    private String email;
    private String telephone;
    private Date birthDay;
}
