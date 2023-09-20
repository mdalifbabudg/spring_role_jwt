package com.example.springrolejwt.config;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    private String name;


    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Role))return false;
        return Objects.nonNull(this.getId()) &&
                Objects.equals(this.getId(), (((Role) obj).getId()));
    }

    @Override
    public int hashCode() {
        if(Objects.isNull(this.getId())){
            return this.getClass().hashCode();
        }
        return this.getId().hashCode();
    }
}
