package com.springrest.springrest.pojo;


import java.util.Date;

public class Employee{

        private long empId;
        private String name;
        private double sal;
        private int age;
        private String date;

        public long getEmpId() {
            return empId;
        }

        public void setEmpId(long empId) {
            this.empId = empId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSal() {
            return sal;
        }

        public void setSal(double sal) {
            this.sal = sal;
        }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", name='" + name + '\'' +
                    ", sal=" + sal +
                    ", age=" + age +
                    ", date=" + date +
                    '}';
        }
    }
