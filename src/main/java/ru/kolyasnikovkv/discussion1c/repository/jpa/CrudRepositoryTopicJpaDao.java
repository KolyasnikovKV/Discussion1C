package ru.kolyasnikovkv.discussion1c.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolyasnikovkv.discussion1c.model.Topic;

public interface CrudRepositoryTopicJpaDao extends JpaRepository<Topic, Integer> {
}