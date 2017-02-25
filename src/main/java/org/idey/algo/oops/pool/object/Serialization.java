package org.idey.algo.oops.pool.object;

import java.io.*;

public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileIn =new FileInputStream("/Users/i.dey/Downloads/employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Employee emp = (Employee) in.readObject();
        in.close();
        fileIn.close();
        System.out.println(emp);
    }

    private static class Employee implements Serializable{
        private int Id;
        private String name;
        private int salary;
        private static final long serialVersionUID = 1L;

        public Employee(int id, String name, int salary) {
            Id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "Id=" + Id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
