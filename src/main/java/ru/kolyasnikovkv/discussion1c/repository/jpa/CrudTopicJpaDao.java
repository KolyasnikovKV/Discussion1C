package ru.kolyasnikovkv.discussion1c.repository.jpa;

import org.springframework.stereotype.Repository;
import ru.kolyasnikovkv.discussion1c.model.CrudDao;
import ru.kolyasnikovkv.discussion1c.model.Topic;
import ru.kolyasnikovkv.discussion1c.model.User;

@Repository
public class CrudTopicJpaDao implements CrudDao<Topic> {

  private final CrudRepositoryTopicJpaDao jpaRepository;

  public CrudTopicJpaDao(CrudRepositoryTopicJpaDao jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Topic save(Topic topic) {
    return jpaRepository.save(topic);
  }

  @Override
  public Topic findById(Integer id) {
    return jpaRepository.findById(id).get();
  }

  @Override
  public boolean delete(Integer id) {
    //return (jpaRepository.delete(id) != 0);
    jpaRepository.deleteById(id);
    return true;
  }
}
