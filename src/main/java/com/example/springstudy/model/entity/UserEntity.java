package com.example.springstudy.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity @Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "user_tbl")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
}
