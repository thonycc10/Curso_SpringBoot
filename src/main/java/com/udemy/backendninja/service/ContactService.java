package com.udemy.backendninja.service;


import java.util.List;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;


public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	/*Para eliinar */
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
}
