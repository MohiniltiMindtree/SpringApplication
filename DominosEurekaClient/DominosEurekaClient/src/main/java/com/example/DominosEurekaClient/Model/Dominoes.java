package com.example.DominosEurekaClient.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dominoes {
    @Id
    @Column(name = "ID", length = 65535)
    private int did;

    private String address;

    private String name;

}
