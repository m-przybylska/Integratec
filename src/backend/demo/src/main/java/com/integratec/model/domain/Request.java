package com.integratec.model.domain;

import com.integratec.model.repositories.RequestPriorityRepository;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestId;

    @NotNull(message = "receiverId cannot be null ")
    @Range(min = 1, max = 999, message = "the receiverId size must be in the range 1-999")
    @Column(name = "reciver_id")
    private Long receiver;

    @NotNull(message = "senderId cannot be null")
    @Range(min = 1, max = 999, message = "the senderId size must be in the range 1-999")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    private Account sender;

    @NotEmpty(message = "title cannot be empty")
    @Size(min = 3, max = 70, message = "the title size must be in the range 3-70")
    @Column(name = "title")
    private String title;

    @Size(max = 1000, message = "the maximum size for text is 1000")
    @Column(name = "text")
    private String text;

    @Size(max = 500, message = "the maximum size for comment is 500")
    @Column(name = "comment")
    private String comment;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "send_date")
    @Temporal(TemporalType.DATE)
    private Date sendDate;

    @Column(name = "request_category_id")
    private Long requestCategory;

    @Column(name = "request_priority_id")
    private Long requestPriority;

    @Column(name = "request_status_id")
    private Long requestStatus;

    public Request(Long requestId, Long receiver, Account sender, String title, String text, String comment) {
        this.requestId = requestId;
        this.receiver = receiver;
        this.sender = sender;
        this.title = title;
        this.text = text;
        this.comment = comment;
    }

}
