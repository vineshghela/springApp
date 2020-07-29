package com.QA.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QA.persistence.models.Note;
import com.QA.services.NotesService;

@RestController
@CrossOrigin
@RequestMapping("/notes")
public class NotesController {

	private NotesService service;

	public NotesController(NotesService service) {
		super();
		this.service = service;
	}

	@GetMapping("/get")
	public ResponseEntity<List<Note>> listAllNotes() {
		List<Note> found = service.listAllNotes();
		return ResponseEntity.ok(found);
	}

	@PostMapping("/create")
	public ResponseEntity<Note> addNote(@RequestBody Note note) {
		Note created = service.addNote(note);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> getNote(@PathVariable Long id) {
		Note found = service.getNote(id);
		return ResponseEntity.ok(found);
	}

	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable Long id) {
		boolean deleted = this.service.deleteNote(id);
		return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}