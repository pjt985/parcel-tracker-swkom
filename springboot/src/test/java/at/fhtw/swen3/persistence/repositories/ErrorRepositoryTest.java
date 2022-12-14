package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
class ErrorRepositoryTest {
//
//    @Autowired
//    ErrorRepository repo;
//
//    @Test
//    public void savingTest() {
//        ErrorEntity error = new ErrorEntity();
//        error.setErrorMessage("Error 1");
//        repo.save(error);
//        ErrorEntity actualError = repo.findById(error.getId()).get();
//        assertEquals(error.getId(), actualError.getId());
//        assertEquals(error.getErrorMessage(), actualError.getErrorMessage());
//    }

}