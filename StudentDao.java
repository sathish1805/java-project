package net.first.hibernate.dao;

import java.io.Serializable;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.first.hibernate.model.Student;
import net.first.hibernate.util.HibernateUtil;

public class StudentDao {
public void saveStudent(Student student)
{
	Transaction transaction=null;
	try(Session session=HibernateUtil.getSesssionFactory().openSession())
	{   //start transaction
		transaction =session.beginTransaction();
		//operation1
		Object object=session.save(student);
		//operation2
		session.get(Student.class,(Serializable)object);
	    //commit transaction
		transaction.commit();
	
	}catch(Exception e) {
		if(transaction!=null) {
			transaction.rollback();
		}e.printStackTrace();
	}
}

public void insertStudent()
{
	Transaction transaction=null;
try(Session session =HibernateUtil.getSesssionFactory().openSession())
{
	transaction=session.beginTransaction();
	String hql="INSERT INTO Student(firstName,LastName,email)"+"SELECT FirstName,lastName,email FROM Student";
Query query=session.createQuery(hql);
int result=query.executeUpdate();
System.out.println("Rows Affected:"+result);
//commit transaction
transaction.commit();
}catch(Exception e)
{if(transaction!=null) {
	transaction.rollback(); 
}e.printStackTrace();
	}
}
public void updateStudent(Student student)
{
	Transaction transaction=null;
	try(Session session =HibernateUtil.getSesssionFactory().openSession())
	{ //start transaction
		transaction =session.beginTransaction();
		//save student object
		String hql="INSERT INTO Student(firstName,LastName,email)"+"SELECT FirstName,lastName,email FROM Student";
		Query query=session.createQuery(hql);
		query.setParameter("studentId",1);
		int result=query.executeUpdate();
		System.out.println("Rows affected:"+result);
		transaction.commit();
}catch(Exception e) {
	if(transaction!=null) {
		transaction.rollback();
}e.printStackTrace();
}
}
public void deleteStudent(int id)
{
	Transaction transaction=null;
	try(Session session =HibernateUtil.getSesssionFactory().openSession())
	{ //start transaction
		transaction =session.beginTransaction();
	    //delete student object
		Student student =session.get(Student.class,id);
		if(student!=null)
		{
			String hql="DELETE FROM Student"+"WHERE id=:studentid";
			Query query=session.createQuery(hql);
			query.setParameter("studentId",id);
			int result=query.executeUpdate();
			System.out.println("Rows affected:"+result);
			//commit transaction 
			transaction.commit();
		}
	}	
	catch(Exception e) {
		if(transaction!=null) {
			transaction.rollback();
	}e.printStackTrace();
	}
}
}