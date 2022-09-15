package com.pojo;

import java.util.List;

public class User {
		private String name;
		private int age;
		private long contact;
		private String emailId;
		private String gender;
		private String username,password,location;
		List<String> courseList;
		
		public User() {
			
		}
		
		public User(String name, int age, long contact, String emailId, String gender, String username, String password,
				String location, List<String> courseList) {
			super();
			this.name = name;
			this.age = age;
			this.contact = contact;
			this.emailId = emailId;
			this.gender = gender;
			this.username = username;
			this.password = password;
			this.location = location;
			this.courseList = courseList;
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
		public long getContact() {
			return contact;
		}
		public void setContact(long contact) {
			this.contact = contact;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public List<String> getCourseList() {
			return courseList;
		}
		public void setCourseList(List<String> courseList) {
			this.courseList = courseList;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + ", contact=" + contact + ", emailId=" + emailId + ", gender="
					+ gender + ", username=" + username + ", password=" + password + ", location=" + location
					+ ", courseList=" + courseList + "]";
		}
		
		
		
		
}
