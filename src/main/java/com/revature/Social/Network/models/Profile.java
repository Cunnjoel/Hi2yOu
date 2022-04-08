package com.revature.Social.Network.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "profiles")
public class Profile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String pictureUrl;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userId")
    private User user;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleInit;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = true)
    private String aboutMe;
}
