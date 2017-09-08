package com._520it.crm.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javafx.scene.effect.Bloom;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vipmember {
    private Long id;

//    VIP
    private String vipname;

    private String vipmemberproportion;

    private String vipserverproption;

    private Boolean vipstart;


}