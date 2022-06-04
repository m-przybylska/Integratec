package com.integratec.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "request_priority")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestPriority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long request_priority_id;

    @Column(name = "request_priority")
    private String request_priority;

}
