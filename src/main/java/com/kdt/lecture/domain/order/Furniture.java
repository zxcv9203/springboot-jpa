package com.kdt.lecture.domain.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Setter
@Getter
@Entity
@DiscriminatorColumn(name = "FURNITURE")

public class Furniture extends Item {
    private int width;
    private int height;
}
