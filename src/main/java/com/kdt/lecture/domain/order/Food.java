package com.kdt.lecture.domain.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Food extends Item {
    private String chef;

}
