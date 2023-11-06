package com.ArcomTech.ApiV1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project", schema = "public")
public class Project {
    @Column(name = "id")
    private @Id
    @GeneratedValue Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "date-debut")
    private Date dateDebut;
    @Column(name = "type")
    private String type;
    @Column(name = "languages")
    private String languages;

    @Column(name = "framework")
    private String framework;

    @Column(name = "url")
    private String url;
}
