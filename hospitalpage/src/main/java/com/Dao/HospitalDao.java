package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HospitalDao 
{
	private String doct_name;
	private int doc_id;
	private String doc_pass;
	private String doc_specialization;
	private int pat_id;
	private String pat_name;
	private String pat_pass;
	private int hospital_id;
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getDoct_name() {
		return doct_name;
	}
	public void setDoct_name(String doct_name) {
		this.doct_name = doct_name;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_pass() {
		return doc_pass;
	}
	public void setDoc_pass(String doc_pass) {
		this.doc_pass = doc_pass;
	}
	public String getDoc_specialization() {
		return doc_specialization;
	}
	public void setDoc_specialization(String doc_specialization) {
		this.doc_specialization = doc_specialization;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getPat_pass() {
		return pat_pass;
	}
	public void setPat_pass(String pat_pass) {
		this.pat_pass = pat_pass;
	}
	
	public boolean doctorValidate(String username,String password,int h_id)
	{
		String query="select * from doctors where doct_name=? and doc_password=? and hospital_id=? ";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "password");
			PreparedStatement ps=con.prepareStatement(query);
		    ps.setString(1, username);
		    ps.setString(2, password);
		    ps.setInt(3, h_id);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	return true;
		    }
		    
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean patientValidate(String username,String password,int h_id)
	{
		String query="select * from patients where pat_name=? and pat_pass=?and hospital_id=?";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "password");
			PreparedStatement ps=con.prepareStatement(query);
		    ps.setString(1, username);
		    ps.setString(2, password);
		    ps.setInt(3, h_id);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	return true;
		    }
		    
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public boolean getHospital(int h_id)
	{
		String query="select * from hospital where hospital_id=?";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "password");
			PreparedStatement ps=con.prepareStatement(query);
		    ps.setInt(1, h_id);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	return true;
		    }
		    
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}
	

}
