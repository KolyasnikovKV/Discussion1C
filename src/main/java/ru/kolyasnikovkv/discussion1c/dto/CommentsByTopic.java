package ru.kolyasnikovkv.discussion1c.dto;

import lombok.Getter;
import lombok.Setter;
import ru.kolyasnikovkv.discussion1c.model.Comment;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CommentsByTopic implements Serializable {
    private static final long serialVersionUID = 8082073760910701836L;
    private Integer id;
    private Integer topicId;
    private Integer userId;
    private String content;
    private Date inTime;
    private Integer commentId;
    private String upIds;
    private String username;
    private String avatar;
    private Integer layer;
}
