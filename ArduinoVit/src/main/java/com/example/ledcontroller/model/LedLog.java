package com.example.ledcontroller.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LedLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime timestamp = LocalDateTime.now();

    public LedLog() {}

    public LedLog(String status) {
        this.status = status;
    }

    public Long getId() { return id; }

    public String getStatus() { return status; }

    public LocalDateTime getTimestamp() { return timestamp; }

    public void setId(Long id) { this.id = id; }

    public void setStatus(String status) { this.status = status; }

    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}