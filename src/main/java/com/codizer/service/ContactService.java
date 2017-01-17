package com.codizer.service;

import java.util.List;

import com.codizer.entity.Contact;
import com.codizer.model.ContactModel;

public interface ContactService {

	ContactModel addContact(ContactModel contactModel);
	
	List<ContactModel> listAllContacts();
	
	Contact findContactById(int id);
	
	void removeContact(int id);
	
	ContactModel findContactModelById(int id);
}
