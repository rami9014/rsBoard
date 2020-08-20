package com.rs.board.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
	
    @Id @GeneratedValue
    @Column(name="id")
    private Long id;
    
    @Column(name="username", nullable = false)
    private String username;
    
    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="password", nullable = false)
    private String password;
	
}
