package com.connect;

public class ObjectCreation {

	DatabaseConnection conn;

	public ObjectCreation() {
		// TODO Auto-generated constructor stub
		conn=new DatabaseConnection();
	}

	public void createObject(){

		int num=0;

		num=conn.count("Select count(client_master.clientunkid) as CNT from client_master");

		if(num==0){
			System.out.println("No records...");
		}

		MailConnect ob[]=new MailConnect[num];
		//ob[1].connect();

		for(int i=0; i<num; i++){
			ob[i]=new MailConnect();
			ob[i].start();
		}	
	}

	public static void main(String args[]){
		ObjectCreation oc=new ObjectCreation();
		oc.createObject();
	}
}
