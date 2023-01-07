package com.example.Consumerdemo.jpa;

import com.example.Consumerdemo.entity.LibraryEvent;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent,Integer> {
}
