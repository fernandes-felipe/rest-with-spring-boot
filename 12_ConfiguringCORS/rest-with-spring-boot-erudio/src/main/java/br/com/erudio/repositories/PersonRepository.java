package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Person;

//Devemos passar o objeto da model e o id o tipo do id da model, no caso long

public interface PersonRepository extends JpaRepository<Person, Long>{}
