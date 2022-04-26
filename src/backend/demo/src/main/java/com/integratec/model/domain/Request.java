package com.integratec.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Request {
    @Id
    @NotNull(message = "requestId cannot be null")
    @Range(min = 1, max = 999999, message = "the requestId size must be in the range 1-999999")
    @SequenceGenerator(name = "requestSequence", sequenceName = "requestSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestSequence")
    private Long requestId;

    @NotNull(message = "receiverId cannot be null ")
    @Range(min = 1, max = 999, message = "the receiverId size must be in the range 1-999")
    @Column(name = "Receiver")
    private Long receiver;

    @NotNull(message = "senderId cannot be null")
    @Range(min = 1, max = 999, message = "the senderId size must be in the range 1-999")
    @Column(name = "Sender")
    private Long sender;

    @NotEmpty(message = "title cannot be empty")
    @Size(min = 3, max = 70, message = "the title size must be in the range 3-70")
    @Column(name = "Title")
    private String title;

    @Size(max = 1000, message = "the maximum size for text is 1000")
    @Column(name = "Text")
    private String text;

    @Size(max = 500, message = "the maximum size for comment is 500")
    @Column(name = "Comment")
    private String comment;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "SendDate")
    @Temporal(TemporalType.DATE)
    private Date sendDate;

    @Column(name = "RequestStatus")
    private Long requestStatus;

    @Column(name = "RequestCategory")
    private Long requestCategory;

    @Column(name = "RequestPriority")
    private Long requestPriority;

    public Request(Long requestId, Long receiver, Long sender, String title, String text, String comment) {
        this.requestId = requestId;
        this.receiver = receiver;
        this.sender = sender;
        this.title = title;
        this.text = text;
        this.comment = comment;
    }

}
