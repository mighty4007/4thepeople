package com.medi.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.medi.exception.MediException;
import com.medi.model.UserDetails;
import com.medi.utils.MediConstants;

public class UserController {

	public static UserDetails getUser(String userID, String userName, String pass) throws IOException {
		Map<String, UserDetails> userlist = null;
		FileInputStream fis = null;
		UserDetails user = null;

		try {
			fis = new FileInputStream(MediConstants.DATA_CONFIG_PATH + "UsersData.src");
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(fis);
				userlist = (Map<String, UserDetails>) ois.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			System.out.println("@@@@@@@@@@@@@@@@@@ Entered to File Not found @@@@@@@@@@@@");
			e.printStackTrace();

			return createMasterUser();

		} finally {
			if (fis != null) {
				fis.close();
			}
		}

		System.out.println(userlist + ":" + userlist.containsKey(userID) + ":" + userID);
		if (userlist.containsKey(userID)) {
			user = userlist.get(userID);

			if (userID.equalsIgnoreCase(user.getUserID()) && userName.equalsIgnoreCase(user.getUserName())
					&& pass.equals(user.getPassword())) {
				return user;
			}
		} else {

			throw new MediException(MediConstants.LOGIN_FAIL_ERROE);
		}

		return user;

	}

	public static UserDetails createMasterUser() {

		UserDetails master = new UserDetails("9999", "admin", "admin", new Date(), 1, MediConstants.ADMIN_USER_ROLE);
		UserDetails loginuser = new UserDetails("1111", "user", "user", new Date(), 1, MediConstants.LOGIN_USER_ROLE);

		ObjectOutputStream ois = null;

		Map<String, UserDetails> m = new HashMap<String, UserDetails>();
		m.put(master.getUserID(), master);
		m.put(loginuser.getUserID(), loginuser);

		try {
			FileOutputStream fos = new FileOutputStream(MediConstants.DATA_CONFIG_PATH + "UsersData.src");

			ois = new ObjectOutputStream(fos);
			ois.writeObject(m);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return master;
	}

//	public static void main(String[] args) {
//
//		try {
//			UserDetails user = UserController.getUser("1111", "admin", "admin");
//
//			System.out.println(user.getUserID());
//			System.out.println(user.getUserName());
//			System.out.println(user.getStatus());
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
