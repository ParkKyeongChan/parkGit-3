package org.spring.codingStory.buschatbot.repository;

import org.spring.codingStory.buschatbot.entity.BusAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusAnswerRepository extends JpaRepository<BusAnswer,Long> {

  Optional<BusAnswer> findByKeyword(String keyword);
}
