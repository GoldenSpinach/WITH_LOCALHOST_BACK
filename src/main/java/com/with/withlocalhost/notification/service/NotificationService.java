package com.with.withlocalhost.notification.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.with.withlocalhost.constant.FcmConstantMessage;
import com.with.withlocalhost.notification.repository.NotificationRepository;
import com.with.withlocalhost.user.model.service.FcmService;

@Service
public class NotificationService {

	private final NotificationRepository notiRepo;
	private final FcmService fcmService;
	
	public NotificationService(NotificationRepository notiRepo ,FcmService fcmService) {
		this.notiRepo = notiRepo;
		this.fcmService = fcmService;
	}

	/*
	 * 예약 메세지
	 */
	public void sendReservationMessage(int tourId) throws SQLException {
		String receiver = notiRepo.sendReservationMessage(tourId);
		fcmService.sendNotification(receiver,FcmConstantMessage.FCM_MESSAGE_TITLE , FcmConstantMessage.RESERVATION_MESSAGE);
	}

	/*
	 * 예약 완료
	 */
	public void sendReservationSuccessMessage(int reservationId) throws SQLException {
		String receiver = notiRepo.sendReservationSuccessMessage(reservationId);
		fcmService.sendNotification(receiver, FcmConstantMessage.FCM_MESSAGE_TITLE , FcmConstantMessage.RESERVATION_ACCEPT_MESSAGE);
	}

	/*
	 * 예약 취소
	 */
	public void sendReservationCancelMessage(int reservationId) throws SQLException {
		String receiver = notiRepo.sendReservationCancelMessage(reservationId);
		fcmService.sendNotification(receiver, FcmConstantMessage.FCM_MESSAGE_TITLE , FcmConstantMessage.RESERVATION_CANCEL);
	}

	/*
	 * 리뷰 등록
	 */
	public void sendNewReviewMessage(int reviewId) throws SQLException {
		String receiver = notiRepo.sendNewReviewMessage(reviewId);
		fcmService.sendNotification(receiver, FcmConstantMessage.FCM_MESSAGE_TITLE , FcmConstantMessage.NEW_REVIEW_MESSAGE);
	}

}
