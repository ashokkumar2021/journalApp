package com.abc.service;


import com.abc.entity.JournalEntry;
import com.abc.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalrepo;

    public void saveEntry(JournalEntry journalEntry){
          journalrepo.save(journalEntry);
    }

    public List<JournalEntry> getAllEntry(){
        return journalrepo.findAll();
    }

    public Optional<JournalEntry> getEntryById(String id){
        return journalrepo.findById(id);
    }

    public void deleteEntry(String id){
       journalrepo.deleteById(id);
    }

    public void updateEntry(String id,JournalEntry newentry){
      JournalEntry oldentry = journalrepo.findById(id).orElse(null);
      if(oldentry != null){
          oldentry.getTitle();
      }
    }
}
