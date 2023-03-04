package com.evoter.poll.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

/**
 * @author showunmioludotun
 */
@Entity
@Table(
        name = "polls",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "poll_type_unique",
                        columnNames = {"pollTypeId"}
                )
        }
)
public class Poll {

    @Id
    @SequenceGenerator(
            name = "poll_sequence",
            sequenceName = "poll_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "poll_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
        nullable = false
    )
    private Integer pollTypeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
        nullable = false
    )
    private Date pollDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }

    public Poll(Long id, Integer pollTypeId, Date pollDate, Date createdAt) {
        this.id = id;
        this.pollTypeId = pollTypeId;
        this.pollDate = pollDate;
        this.createdAt = createdAt;
    }

    public Poll() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPollTypeId() {
        return pollTypeId;
    }

    public void setPollTypeId(Integer pollTypeId) {
        this.pollTypeId = pollTypeId;
    }

    public Date getPollDate() {
        return pollDate;
    }

    public void setPollDate(Date pollDate) {
        this.pollDate = pollDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Poll poll = (Poll) o;
        return Objects.equals(id, poll.id) && Objects.equals(pollTypeId, poll.pollTypeId) && Objects.equals(pollDate, poll.pollDate) && Objects.equals(createdAt, poll.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pollTypeId, pollDate, createdAt);
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", pollTypeId=" + pollTypeId +
                ", pollDate=" + pollDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
