package kr.hs.gbsw.database.bbs.repository;

import com.fasterxml.jackson.core.type.WritableTypeId;
import kr.hs.gbsw.database.bbs.entity.Writing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WritingRepositoryTest {

    @Autowired
    private WritingRepository writingRepository;

    @Test
    public void testWrite() {
        Writing writing = new Writing();
        writing.setTitle("Hello BBS");
        writing.setContent("My name is GBSW");
        writing.setWriter("Mr. Brown");

        writingRepository.save(writing);

        Optional<Writing> optional =
                writingRepository.findById(writing.getIdx());

        Writing saved = optional.get();
        assertEquals(writing.getIdx(), saved.getIdx());
        assertEquals(writing.getTitle(), saved.getTitle());
        assertEquals(writing.getContent(), saved.getContent());
        assertEquals(writing.getWriter(), saved.getWriter());
    }


}