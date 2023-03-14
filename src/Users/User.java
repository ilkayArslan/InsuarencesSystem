package Users;

import Adresses.IAdress;

import java.util.ArrayList;
import java.util.Date;


public class User {
   private String name;
   private  String surname;
   private String email;
   private String password;
   private String  job;
   private int age;
   private Date date;
   private ArrayList<IAdress> adresses = new ArrayList<>();

   public User(String name, String surname, String email, String password, String job, int age) {
      this.name = name;
      this.surname = surname;
      this.email = email;
      this.password = password;
      this.job = job;
      this.age = age;
      this.date = new Date();
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getJob() {
      return job;
   }

   public void setJob(String job) {
      this.job = job;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public void getAdressesList() {
      for (int i =0;i<this.adresses.size();i++){
         System.out.println(i+1+" - "+adresses.get(i).gettheadress());
      }
   }

   public ArrayList<IAdress> getAdresses() {
      return adresses;
   }

   public void setAdresses(ArrayList<IAdress> adresses) {
      this.adresses = adresses;
   }
}
