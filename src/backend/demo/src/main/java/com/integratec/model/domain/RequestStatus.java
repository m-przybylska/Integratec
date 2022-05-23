package com.integratec.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "request_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long request_status_id;

    @Column(name = "request_status")
    private String request_status;

}
