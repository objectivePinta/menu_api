package com.objective.payntza.attractions.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String username;
  String password;
}
