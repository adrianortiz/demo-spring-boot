package com.codizer.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codizer.entity.Contact;

// Para obtener la funcionalidad de JPA
@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable>{

}
