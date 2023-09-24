package buta.creditapplication.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String surname;
    String fatherName;
    String phoneNumber;
    String residentialPhone;
    String birthday;
    String address;
    String actualAddress;
    String email;
    String serie;
    String fin;
    String password;
}
