package com.mbb.jpa.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="ADDRESS")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    
    // one to one mapping means,
    // one employee stays at one address only
    @OneToOne
    private Employee employee;
    
}