package com.spring.abir.module3hospital.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Patient patient; // owning side

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Doctor doctor; // owning side
}
