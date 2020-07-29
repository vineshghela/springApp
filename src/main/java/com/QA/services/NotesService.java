package com.QA.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.QA.exceptions.NoteNotFoundException;
import com.QA.persistence.models.Note;
import com.QA.persistence.repo.NotesRepository;

@Service
public class NotesService {

	private NotesRepository repo;

	public NotesService(NotesRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Note> listAllNotes() {
		return repo.findAll();
	}

	public Note addNote(Note note) {
		return repo.saveAndFlush(note);
	}

	public Note getNote(Long id) {
		Note found = this.repo.findById(id).orElseThrow(NoteNotFoundException::new);
		return found;
	}

	public boolean deleteNote(Long id) {
		this.repo.deleteById(id);
		boolean deleted = !this.repo.existsById(id);
		return deleted;
	}

}