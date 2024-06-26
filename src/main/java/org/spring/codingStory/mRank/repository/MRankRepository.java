package org.spring.codingStory.mRank.repository;

import org.spring.codingStory.mRank.entity.RankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MRankRepository extends JpaRepository<RankEntity,Long> {
  Optional<RankEntity> findByRankName(String rankName);
}
