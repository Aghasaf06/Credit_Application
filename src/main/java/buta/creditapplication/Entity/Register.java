package buta.creditapplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "register")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String phoneNumber;
    private String residentialPhone;
    private String birthday;
    private String address;
    private String actualAddress;
    private String fin;
    private String serie;
    private String password;
}