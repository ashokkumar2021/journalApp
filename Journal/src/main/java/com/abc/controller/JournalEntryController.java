package com.abc.controller;

import com.abc.entity.JournalEntry;
import com.abc.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalService journalservice;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalservice.getAllEntry();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry){
        entry.setDate(LocalDateTime.now());
        journalservice.saveEntry(entry);
        return entry;
    }

    @GetMapping("id/{myId}")
    public Optional<JournalEntry> getJournalEntryById(@PathVariable String myId){
       return journalservice.getEntryById(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable String myId){
        journalservice.deleteEntry(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalById(@PathVariable String id, @RequestBody JournalEntry newentry){
        journalservice.updateEntry(id,newentry);
        return newentry;
    }
}
