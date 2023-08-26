package server;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String address;
    private String contact;

    public Student(int id, String name, int age, String address, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public void saveStudent(Student student) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    public void deleteStudent(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateStudent(Student student) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void extractStudentXML(Student student) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void sortStudent(String sortTxt) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fetchStudent(Student student) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Student getStudentByID(int id) throws RemoteException {
        throw new UnsupportedOperationException("NotSupported yet");
    }
}