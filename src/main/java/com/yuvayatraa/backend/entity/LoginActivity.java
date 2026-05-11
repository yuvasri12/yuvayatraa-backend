package com.yuvayatraa.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "login_activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String role;

    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;

    private String ipAddress;

    @PrePersist
    public void prePersist() {
        this.loginTime = LocalDateTime.now();
    }
}