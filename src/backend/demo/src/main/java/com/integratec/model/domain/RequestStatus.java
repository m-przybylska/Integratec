package com.integratec.model.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "requeststatus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestStatusId;

    @Column(name = "request_status")
    private String requestStatus;

}
