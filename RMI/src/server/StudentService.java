/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package server;

/**
 *
 * @author ADMIN
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentService extends Remote {
    void saveStudent(Student student) throws RemoteException;
    void deleteStudent(int id) throws RemoteException;
    void updateStudent(Student student) throws RemoteException;
    void extractStudentXML(Student student) throws RemoteException;
    List<Student> sortStudent(String sortTxt) throws RemoteException;
    List<Student> fetchStudent() throws RemoteException;
    Student getStudentByID(int id) throws RemoteException;
}
