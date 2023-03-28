package com.evoter.poll.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

/**
 * @author showunmioludotun
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "polls")
public class Poll {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(nullable = false)
    private Integer pollTypeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date pollDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }
}
