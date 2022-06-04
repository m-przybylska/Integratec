package com.integratec.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "request_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long request_category_id;

    @Column(name = "request_category")
    private String request_category;

}
