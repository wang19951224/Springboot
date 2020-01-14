package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Site {
    private String pid;
    private Integer oprice;
    private String cname;
    private String getcity;
    private String backcity;
    private String ostatus;
}
