package ru.kolyasnikovkv.discussion1c.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.kolyasnikovkv.discussion1c.dto.CommentsByTopic;
import ru.kolyasnikovkv.discussion1c.model.Comment;
import ru.kolyasnikovkv.discussion1c.model.User;
import ru.kolyasnikovkv.discussion1c.repository.jpa.CrudCommentJpaDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CommentService {

    private final CrudCommentJpaDao repository;
    private EntityManager entityManager;

//        <select id="selectByTopicId" resultType="ru.kolyasnikovkv.discussion1c.model.vo.CommentsByTopic">
//    select c.*, u.username, u.avatar, 0 as layer
//    from comment c
//    left join user u on c.user_id = u.id
//    where c.topic_id = #{topicId}
//    order by c.in_time asc
//    </select>
    //@Query("c.*, u.username, u.avatar, 0 as layer from Comment c  left join User u on c.user_id = u.id  where c.topic_id = ?1  order by c.in_time asc")
    //CommentsByTopic selectByTopicId(Integer id);
     public List<CommentsByTopic> selectByTopicId(Integer id){

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(
                "select c, u.username, u.avatar, 0 as layer " +
                        "from Comment c " +
                        "left join User u on c.userId = u.id" +
                        " where c.topicId = :topic_id" +
                        " order by c.inTime asc", Object[].class);
         List<Object[]> comments = typedQuery.setParameter( "topic_id", id ).getResultList();

         List<CommentsByTopic> listCommentsByTopic  = new ArrayList<CommentsByTopic>();
         for(Object[] item: comments){
             Comment comment = (Comment) item[0];
             CommentsByTopic commentsByTopic = new CommentsByTopic();
             commentsByTopic.setId(comment.getId());
             commentsByTopic.setTopicId(comment.getTopicId());
             commentsByTopic.setUserId(comment.getUserId());
             commentsByTopic.setContent(comment.getContent());
             commentsByTopic.setInTime(comment.getInTime());
             commentsByTopic.setCommentId(comment.getCommentId());
             commentsByTopic.setUpIds(comment.getUpIds());
             commentsByTopic.setUsername((String) item[1]);
             commentsByTopic.setAvatar((String) item[2]);
             commentsByTopic.setLayer((Integer) item[3]);
             listCommentsByTopic.add(commentsByTopic);
         }


         //Object[] commentsByTopic = typedQuery.setParameter( "topic_id", id ).;
        return listCommentsByTopic;
    }
}