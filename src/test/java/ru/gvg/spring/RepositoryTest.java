package ru.gvg.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gvg.spring.model.News;
import ru.gvg.spring.repository.NewsRepository;

import static org.junit.Assert.assertTrue;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.08.2018.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private NewsRepository repository;

    @Test
    public void findByNameTest() {
        this.entityManager.persist(new News("news1", "new news1"));
        News post = this.repository.findOne("news1");
        assertTrue(post.getId().equals("news1"));
        assertTrue(post.getText().equals("new news1"));
    }
}
