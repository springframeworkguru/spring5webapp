package guru.springframework.spring5webapp.dao;

import guru.springframework.spring5webapp.domain.Author;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ActiveProfiles("local")
@DataJpaTest
@RunWith(SpringRunner.class)

//@Import(AuthorDaoImpl.class)
@ComponentScan(basePackages = {"guru.springframework.spring5webapp.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class AuthorDaoImplTest extends TestCase {

    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testGetAuthorByName() {
        Author author = authorDao.findAuthorByName("Craig", "Walls");

        assertNotNull(author);
    }

    @Test
    public void testGetById() {
        Author author = authorDao.getById(1L);
        assertNotNull(author);
    }

    @Test
    public void test_find_all_author_pagable() {
        List<Author> allAuthors = authorDao.getAllAuthors(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "id")));
        assertEquals(1, allAuthors.size());
    }

    @Test
    public void test_find_all_author_page_offiset() {
        List<Author> allAuthors = authorDao.getAllAuthors(0, 1);
        assertEquals(1, allAuthors.size());
    }
    @Test
    public void test_find_all_author_By_first_name() {
        List<Author> allAuthors = authorDao.getAuthorByFirstName("Craig", PageRequest.of(0, 1));
        assertEquals(1, allAuthors.size());
    }
}
