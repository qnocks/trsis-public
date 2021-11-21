package com.example.lab5.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String birthDate;

    @OneToOne(mappedBy = "customer")
    private Purchase purchase;
}
