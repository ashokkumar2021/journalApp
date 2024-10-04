package com.abc.repository;


import com.abc.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalRepository extends MongoRepository<JournalEntry,String> {

}