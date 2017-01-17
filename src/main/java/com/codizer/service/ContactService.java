package com.codizer.service;

import java.util.List;

import com.codizer.model.ContactModel;

public interface ContactService {

	ContactModel addContact(ContactModel contactModel);
	
	List<ContactModel> listAllContacts();
}
