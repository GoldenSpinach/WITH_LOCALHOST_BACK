package com.with.withlocalhost.user.model.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.with.withlocalhost.user.model.UserFcmDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FcmService {

	public void sendNotification(String token , String title , String body) {
			Message message = Message.builder().putData("title", title).putData("body", body).setToken(token).build();

			try {
				String response = FirebaseMessaging.getInstance().send(message);
				System.out.println("Successfully sent message: " + response);
			} catch (Exception e) {
				System.err.println("Error sending FCM message: " + e.getMessage());
			}
		
	}
}
