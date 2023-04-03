package kr.hs.gbsw.database.bbs.repository;

import kr.hs.gbsw.database.bbs.entity.Writing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingRepository
        extends JpaRepository<Writing, Long> {
}
