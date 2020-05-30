package com.example.lab3.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Archive {
    private long archiveId;
    private Registration registration;
    private int mark;
    private Timestamp date;
}
