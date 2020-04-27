package ru.kolyasnikovkv.discussion1c.repository.jpa;

import org.springframework.stereotype.Repository;
import ru.kolyasnikovkv.discussion1c.model.CrudDao;
import ru.kolyasnikovkv.discussion1c.model.User;

@Repository
public class CrudUserJpaDao implements CrudDao<User> {

  private final CrudRepositoryUserJpaDao jpaRepository;

  public CrudUserJpaDao(CrudRepositoryUserJpaDao jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public User save(User user) {
    return jpaRepository.save(user);
  }

  @Override
  public User findById(Integer id) {
    return jpaRepository.findById(id).get();
  }

  @Override
  public boolean delete(Integer id) {
    //return (jpaRepository.delete(id) != 0);
    jpaRepository.deleteById(id);
    return true;
  }
}
