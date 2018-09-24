package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    public TimeEntry(){}
    public TimeEntry(long id, long projectId, long userId, LocalDate dae, int hours) {
            this.id=id;
          this.projectId=projectId;
          this.userId=userId;
        this.date=dae;
        this.hours=hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate dae, int hours) {
        this.projectId=projectId;
        this.userId = userId;
        this.date=dae;
        this.hours=hours;
    }

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;

    public void setId(long id) {
        this.id = id;
    }

    private int hours;

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return
                id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
