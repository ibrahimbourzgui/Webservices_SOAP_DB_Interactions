package service;

import java.util.List;

import model.Contact;

public interface IContactService {
	public Contact add(Contact c) throws ClassNotFoundException;
	public void delete(int ref) throws ClassNotFoundException;
	public Contact findById(int ref) throws ClassNotFoundException;
	public Contact update(Contact c) throws ClassNotFoundException;
	public List<Contact> selectAll() throws ClassNotFoundException;
}
