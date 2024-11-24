package com.with.withlocalhost.notification.repository;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotificationRepository {

	String sendReservationMessage(int tourId) throws SQLException;
	
	String sendReservationSuccessMessage(int reservationId) throws SQLException;
	
	String sendReservationCancelMessage(int reservationId) throws SQLException;
	
	String sendNewReviewMessage(int reviewId) throws SQLException;
	
	
}
