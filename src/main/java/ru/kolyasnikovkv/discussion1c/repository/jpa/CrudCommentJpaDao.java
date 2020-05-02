package ru.kolyasnikovkv.discussion1c.repository.jpa;

import org.springframework.stereotype.Repository;
import ru.kolyasnikovkv.discussion1c.model.Comment;
import ru.kolyasnikovkv.discussion1c.model.CrudDao;
import ru.kolyasnikovkv.discussion1c.model.User;

@Repository
public class CrudCommentJpaDao implements CrudDao<Comment> {

  private final CrudRepositoryCommentJpaDao jpaRepository;

  public CrudCommentJpaDao(CrudRepositoryCommentJpaDao jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Comment save(Comment comment) {
    return jpaRepository.save(comment);
  }

  @Override
  public Comment findById(Integer id) {
    return jpaRepository.findById(id).get();
  }

  @Override
  public boolean delete(Integer id) {
    //return (jpaRepository.delete(id) != 0);
    jpaRepository.deleteById(id);
    return true;
  }
}
