package com.alaskalany.careershowcase.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class Duration {

    @ColumnInfo(name = "duration")
    private String duration;
    @ColumnInfo(name = "start_date")
    private String startDate;
    @ColumnInfo(name = "end_date")
    private String endDate;

    public Duration() {

    }

    public String getDuration() {

        return duration;
    }

    public void setDuration(String duration) {

        this.duration = duration;
    }

    public String getStartDate() {

        return startDate;
    }

    public void setStartDate(String startDate) {

        this.startDate = startDate;
    }

    public String getEndDate() {

        return endDate;
    }

    public void setEndDate(String endDate) {

        this.endDate = endDate;
    }
}