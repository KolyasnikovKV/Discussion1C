package ru.kolyasnikovkv.discussion1c.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolyasnikovkv.discussion1c.model.Comment;

import java.util.List;

public interface CrudRepositoryCommentJpaDao extends JpaRepository<Comment, Integer> {
}