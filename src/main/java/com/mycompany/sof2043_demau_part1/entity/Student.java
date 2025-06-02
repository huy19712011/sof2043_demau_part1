package com.mycompany.sof2043_demau_part1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private long id;
    private String name;
    private String email;
    private String phone;

}
