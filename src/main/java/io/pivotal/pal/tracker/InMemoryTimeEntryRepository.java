package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

private Map<Long, TimeEntry> timeEntries = new HashMap<>();
private long idCounter = 1L;;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
    Long id = idCounter++;
        //idCounter++;
        TimeEntry timeentry = new TimeEntry(id,timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours() );
        timeEntries.put(id,timeentry);
        return timeentry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(find(id)== null)
        return null;

        TimeEntry updatedEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntries.replace(id,updatedEntry);

        return updatedEntry;
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);

    }
}
