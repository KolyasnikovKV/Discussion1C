package ru.kolyasnikovkv.discussion1c.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Embeddable
@Table(name = "comment")
@Getter
@Setter
@EqualsAndHashCode
public class Comment implements Serializable {
    private static final long serialVersionUID = 8413239906874427490L;

    @Id
    @GeneratedValue
    private Integer id;
    //А всегда ли нужны эти связи?
    @Transient
    @ManyToOne
    @JoinColumn(name = "topic_id",
            foreignKey = @ForeignKey(name = "comment_ibfk_1"))
    private Topic topic;
    private Integer topicId;
    @Transient
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "comment_ibfk_2"))
    private User user;
    private Integer userId;
    private String content;
    private Date inTime;
    private Integer commentId;
    private String upIds;

}
