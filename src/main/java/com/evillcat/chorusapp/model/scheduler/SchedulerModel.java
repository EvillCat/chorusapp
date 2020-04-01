package com.evillcat.chorusapp.model.scheduler;

import com.evillcat.chorusapp.model.Event;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "scheduler")
@Entity
public class SchedulerModel {

    @Id
    @GeneratedValue
    public Long id;

    @OneToOne
    @JoinColumn(name = "event_id")
    public Event event;

    @Column(name = "notification_times_left")
    public Long notificationTimesLeft;
}
