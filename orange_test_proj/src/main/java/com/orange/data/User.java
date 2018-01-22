package com.orange.data;

public class User {


		private String name;
		private String password;

		public User(String username, String password) {
			this.name = username;
			this.password = password;
		}
		public String getPassword() {
			return this.password;
		}

		public String getName() {
			return this.name;
			}
		
}
