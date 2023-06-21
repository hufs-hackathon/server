package com.hachathon.farmmate.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Crop {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "cult_dt",nullable = false)
    private Date cultivationDt;

    @Column(name = "image")
    private String image;
}
