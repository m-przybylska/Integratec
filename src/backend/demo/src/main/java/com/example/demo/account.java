package com.example.demo;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "konto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "imie")
    private String imie;
    public account(){}

    public account(String imie)
     {
        this.imie = imie;
     }

     public String show()
     {
        return this.imie;
     }
}
