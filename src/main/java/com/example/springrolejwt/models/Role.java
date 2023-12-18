package com.example.springrolejwt.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    @Enumerated(EnumType.STRING)
    RoleName roleName;

    public Role (RoleName roleName) {this.roleName = roleName;}
    public String getRoleName() {
        return roleName.toString();
    }

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
