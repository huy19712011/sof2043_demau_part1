package com.mycompany.sof2043_demau_part1.entity;

import java.math.BigDecimal;
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
public class Product {

    private long id;
    private String name;
    private double price;
//    private BigDecimal price;

    private long categoryId;
}
