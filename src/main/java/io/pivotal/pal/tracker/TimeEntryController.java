package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry entry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(entry, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry entry = timeEntryRepository.find(id);

        if(entry == null)
            return new ResponseEntity<>(entry, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {

        List entries = timeEntryRepository.list();

        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {

        TimeEntry entry = timeEntryRepository.update(id,expected);
        System.out.println("update 8888888-----"+entry);
        if(entry ==null) {
            System.out.println("update not found-----");
           return new ResponseEntity<>(entry, HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(entry, HttpStatus.OK);

    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        System.out.println("deleeeee-----" + id);
        try {
            timeEntryRepository.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        System.out.println("after deleeeee-----" + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
