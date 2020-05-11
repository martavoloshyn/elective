package com.example.lab3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Archive {
    private long archiveId;
    private Registration registration;
    private int mark;
    private Timestamp date;
}
