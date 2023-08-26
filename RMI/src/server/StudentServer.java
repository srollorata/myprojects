/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;
/**
 *
 * @author ADMIN
 */
import java.util.List;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class StudentServer extends UnicastRemoteObject implements StudentService {
    private Connection connection;

    public StudentServer() throws RemoteException {
        super();
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/it106db";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        } catch (Exception e) {
            System.out.println("Cannot connect to database: " + e);
        }
    }

    @Override
    public void saveStudent(Student student) throws RemoteException {
        try {
            String query = "INSERT INTO students( id, name, age, address, contact) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getContact());
            statement.executeUpdate();
            System.out.println("Student saved successfully ");
        } catch (SQLException e) {
            System.out.println("Exception Error: " + e);
        }
    }

    @Override
    public void deleteStudent(int id) throws RemoteException {
        try {
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            System.out.println("SQLException error: " + e);
        }
    }

    @Override
    public void updateStudent(Student student) throws RemoteException {
        try {
            String query = "UPDATE students SET name = ?, age = ?, address = ?, contact = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getAddress());
            statement.setString(4,student.getContact());
            statement.setInt(5,student.getId());
            statement.executeUpdate();
            System.out.println("Student updated successfully");
        } catch (SQLException e) {
            System.out.println("SQL Exception error: " + e);
        }
    }
    
    @Override
    public void extractStudentXML(Student student) throws RemoteException {
        try{
            String query = "INSERT INTO students(id, name, age, address, contact) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getContact());
            statement.executeUpdate();
            System.out.println("Student extracted successfully ");
        } catch(SQLException e){
            System.out.println("Exception Error: " + e);
        }
    }

    @Override
    public List<Student> fetchStudent() throws RemoteException {
        List<Student> students = new ArrayList<>();
        // java.util.List must be imported to use List<> and java.util.ArrayList 
        
        try {
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM students");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                
                Student student = new Student( id, name, age, address, contact);
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e);
        }
        return students;
    }
    
    @Override
    public List<Student> sortStudent(String sortTxt) throws RemoteException {
        List<Student> students = new ArrayList<>();
        // java.util.List must be imported to use List<> and java.util.ArrayList
        
        try {
            PreparedStatement query;
            ResultSet resultSet;
            if(sortTxt.equals("Age")){
                query = connection.prepareStatement("SELECT * FROM students ORDER BY students.age ASC");
            } else if(sortTxt.equals("Name")) {
                query = connection.prepareStatement("SELECT * FROM students ORDER BY students.name ASC");
            } else {
                query = connection.prepareStatement("SELECT * FROM students ORDER BY students.id ASC");
            }
            
            resultSet = query.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String contact = resultSet.getString("contact");
                
                Student student = new Student( id, name, age, address, contact);
                students.add(student);
            }
            System.out.println("Sorted by: " + sortTxt);
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e);
        }
        return students;
    }
    
    @Override
    public Student getStudentByID(int id) throws RemoteException {
        try{
            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentID = resultSet.getInt("id");
                String studentName = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String contact = resultSet.getString("contact");
                return new Student(studentID, studentName, age, address, contact);
            }
        } catch (SQLException e) {
            System.out.println("SQLException error: " + e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        try {
             // Set the hostname or IP address of the server
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            // Create an instance of the server
            StudentServer server = new StudentServer();

            // Bind the server object to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StudentService", server);

            System.out.println("Server started");

        } catch (Exception e) {
            System.out.println("Some server error: " + e);
        }
    }
}