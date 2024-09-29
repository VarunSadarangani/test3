package com.techtitans.tms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teachers {

    @Id
    private int id;
    private String name;
    private String email;
    private String password;
}
