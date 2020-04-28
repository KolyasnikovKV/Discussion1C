package ru.kolyasnikovkv.discussion1c.dto;

import lombok.Getter;
import lombok.Setter;
import ru.kolyasnikovkv.discussion1c.model.Comment;

import java.io.Serializable;
@Getter
@Setter
public class CommentsByTopic extends Comment implements Serializable {
    private static final long serialVersionUID = 8082073760910701836L;
    // Структура данных одного объекта в списке комментариев под темой

    private String username;
    private String avatar;
    // Уровень комментария, если вы непосредственно комментируете тему, уровень равен 0. Если вы отвечаете на комментарий, текущий отвечающий слой - это слой 1 объекта комментария. layer+1
    private Integer layer;
}
