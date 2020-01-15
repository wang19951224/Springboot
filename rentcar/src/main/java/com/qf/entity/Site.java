package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Site {
    private Integer id;
    private Integer oprice;
    private String carName;
    private String status;
    private String getName;
    private String backName;
    private String name1;
    private String name2;

}
