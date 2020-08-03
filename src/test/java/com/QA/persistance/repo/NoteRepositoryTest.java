package com.QA.persistance.repo;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.QA.persistence.models.Note;
import com.QA.persistence.repo.NotesRepository;

@DataJpaTest
public class NoteRepositoryTest {
	
	
	@Autowired
	private NotesRepository repo;

//	private final String TEST_COLOUR = "black";

	private final Note TEST_DUCK = new Note();

	private Note testSavedDuck;

	@BeforeEach
	void init() {
		this.repo.deleteAll();
		this.testSavedDuck = this.repo.save(this.TEST_DUCK);
	}

	@Test
	void testFindByName() {
	
	}

}
