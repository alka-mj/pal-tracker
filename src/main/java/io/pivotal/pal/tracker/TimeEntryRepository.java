package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(long id);
    List<TimeEntry> list();
    public TimeEntry update(long id, TimeEntry timeEntry);
    public void delete(long id);

}
