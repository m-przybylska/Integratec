package com.integratec.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "requestcategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestCategoryId;

    @Column(name = "request_category")
    private String requestCategory;

}