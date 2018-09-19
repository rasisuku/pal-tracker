package io.pivotal.pal.tracker;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    Map<Long,TimeEntry> entries = new HashMap<Long,TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        entries.put (timeEntry.getId(),timeEntry);
        System.out.println("in create - proj id-" +entries.get(timeEntry.getId()).getProjectId());
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {

        return entries.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        TimeEntry entryFound = null;
        for(TimeEntry entry : entries.values())
        {
            if(entry.getId() == timeEntry.getId()) {
                entryFound = entry;
                entries.put(id,timeEntry);
                System.out.println("######---update----" +entries.get(id).getProjectId());
                break;
            }
         }

        System.out.println("in update - proj id-" + entries.get(timeEntry.getId()).getProjectId());

        return entries.get(id);
    }

    @Override
    public List<TimeEntry> list() {

        List<TimeEntry> entriesList = new ArrayList<TimeEntry>();

        for(TimeEntry entry : entries.values())
        {
            entriesList.add(entry);
        }

        return entriesList;
    }

    @Override
    public void delete(long id) throws  Exception{

        boolean entryFound = Boolean.FALSE;


        for(TimeEntry entry : entries.values())
        {
            if(entry.getId() == id) {
                entries.remove(entry.getId());
                entryFound = Boolean.TRUE;
                break;
            }
        }

        if(entryFound == Boolean.FALSE){
            throw new Exception("entry not found");
        }

    }
}
