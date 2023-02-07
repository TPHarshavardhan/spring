package com.springrest.springrest.etities;

import jakarta.persistence.*;
    @Entity
    @Table(name = "emp")
    public class EmployeeDTO {
        @jakarta.persistence.Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "empId", nullable = false)
        private long empId;
        private String name;
        private double sal;
        private int age;
        private String status;
        private String date;
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

        public long getEmpId() {
            return empId;
        }

        public void setEmpId(long empId) {
            this.empId = empId;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }



        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "EmployeeDTO{" +
                    "empId=" + empId +
                    ", name='" + name + '\'' +
                    ", sal=" + sal +
                    ", age=" + age +
                    ", status='" + status + '\'' +
                    ", date=" + date +
                    '}';
        }
    }

