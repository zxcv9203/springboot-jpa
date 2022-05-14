package com.kdt.lecture.domain.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Setter
@Getter
@Entity
@DiscriminatorColumn(name = "FOOD")
public class Food extends Item {
    private String chef;

}
