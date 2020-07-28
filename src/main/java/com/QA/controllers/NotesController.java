package com.QA.controllers;

import com.QA.models.Note;
import com.QA.respository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NotesController {

	@Autowired
    private NotesRepository notesRepository;


    @GetMapping(value = "notes")
    public List<Note> listAllNotes(){
        return notesRepository.findAll();
    }

    @PostMapping(value = "notes", produces = "application/json")
    public Note addNote (@RequestBody Note note){
        return notesRepository.saveAndFlush(note);
    }

    @GetMapping(value = "notes/{id}")
    public Note getNote(@PathVariable Long id ){
        return notesRepository.findOne(id);

    }

    @DeleteMapping(value = "notes/{id}")
    public Note deleteNote (@PathVariable Long id){
        Note exisits = notesRepository.findOne(id);
        notesRepository.delete(exisits);
        return exisits;
    }

}