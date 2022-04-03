package com.integratec.model.domain;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "request")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Request {
    @Id
    @SequenceGenerator(name = "request_sequence", sequenceName = "request_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_sequence")
    private Long requestId;
    @Column(name = "Receiver")
    private Long receiver;
    @Column(name = "Sender")
    private Long sender;
    @Column(name = "Title")
    private String title;
    @Column(name = "Text")
    private String text;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "SendDate")
    @Temporal(TemporalType.DATE)
    private Date sendDate;
    @Column(name = "TaskList")
    private Long taskList;
    @Column(name = "RequestStatusStatus")
    private Long requestStatus;
    @Column(name = "RequestCategoryCategory")
    private Long requestCategory;
    @Column(name = "RequestPriority")
    private Long requestPriority;

    public Request() {
    }

    public Request(Long requestid, Long receiver, Long sender, String title, String text, String comment) {
        this.requestId = requestid;
        this.receiver = receiver;
        this.sender = sender;
        this.title = title;
        this.text = text;
        this.comment = comment;
    }

}
