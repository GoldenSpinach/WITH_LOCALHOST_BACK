package com.with.withlocalhost.notification.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotificationRepository {

    String sendReservationMessage(int reservationId);

    String sendReservationSuccessMessage(int reservationId);

    String sendReservationCancelMessage(int reservationId);

    String sendNewReviewMessage(int reservationId);
}
