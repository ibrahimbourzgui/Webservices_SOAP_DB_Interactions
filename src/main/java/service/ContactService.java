package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.Contact;
import util.DBInteraction;
@WebService(name="contactService")
public class ContactService implements IContactService{
	
   @WebMethod
	public Contact add(@WebParam(name="contact") Contact c) throws ClassNotFoundException {
		DBInteraction.connect();
		String sql="insert into contact(nom,addresseip) values('"+c.getNom()+"','"+c.getAdresseIp()+"')";
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
		return c;
	}
   @WebMethod
	public void delete(int ref) throws ClassNotFoundException {
		DBInteraction.connect();
		String sql="delete from contact where reference="+ref;
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
	}
   @WebMethod
	public Contact update(Contact c) throws ClassNotFoundException {
		DBInteraction.connect();
		String sql="update contact set nom='"+c.getNom()+"',addresseip='"+c.getAdresseIp()+"' where reference='"+c.getReference()+"'";
		DBInteraction.Update(sql);
		DBInteraction.deconnect();
		return c;
	}
	
	
	
   @WebMethod
	public List<Contact> selectAll() throws ClassNotFoundException {
		List<Contact> contac=new ArrayList<Contact>();
		DBInteraction.connect();
		String sql = "select * from contact";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Contact c=new Contact(rs.getInt(1), rs.getString(2), rs.getString(3));
				c.setReference(rs.getInt(1)); 
				contac.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DBInteraction.deconnect();
		return contac;
	}
   @WebMethod
	public Contact findById(int ref) throws ClassNotFoundException {
		Contact contac=null;
		DBInteraction.connect();
		String sql = "select * from contact where reference="+ref;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				
				contac=new Contact(rs.getString(2), rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DBInteraction.deconnect();
		return contac;
	}
}
