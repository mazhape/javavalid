package com.example.domain;

import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.GeneratedValue;


@Serdeable
@MappedEntity
public class Contribution {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;
    private Long hwai_id;
    private Long center;
    private Float amount;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getHwai_id() {
        return hwai_id;
    }

    public void setHwai_id(Long hwaiId) {
        this.hwai_id = hwaiId;
    }

    public Long getCenter() {
        return center;
    }

    public void setCenter(Long center) {
        this.center = center;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}