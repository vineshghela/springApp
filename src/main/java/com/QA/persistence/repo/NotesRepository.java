package com.QA.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QA.persistence.models.Note;

public interface NotesRepository extends JpaRepository<Note, Long> {
}
