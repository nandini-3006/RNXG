package com.nandu.jwt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")  // 💡 Renamed from "user" to "users"
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String role;
}
