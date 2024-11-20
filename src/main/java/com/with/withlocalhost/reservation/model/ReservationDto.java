package com.with.withlocalhost.reservation.model;

import java.util.Date;

public class ReservationDto {

    private int reservationId;        // reservation_id
    private int tourId;               // tour_id
    private String reservater;        // reservater
    private Date startDate;           // start_date
    private Date endDate;             // end_date
    private int reservationPeople;    // reservation_people
    private int reservationPay;       // reservation_pay
    private String reservationStatus; // reservation_status

    // 기본 생성자
    public ReservationDto() {}

    // 필드에 대한 getter와 setter 메서드

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getReservater() {
        return reservater;
    }

    public void setReservater(String reservater) {
        this.reservater = reservater;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getReservationPeople() {
        return reservationPeople;
    }

    public void setReservationPeople(int reservationPeople) {
        this.reservationPeople = reservationPeople;
    }

    public int getReservationPay() {
        return reservationPay;
    }

    public void setReservationPay(int reservationPay) {
        this.reservationPay = reservationPay;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    // toString() 메서드 추가 (선택 사항)
    @Override
    public String toString() {
        return "ReservationDto{" +
                "reservationId=" + reservationId +
                ", tourId=" + tourId +
                ", reservater='" + reservater + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reservationPeople=" + reservationPeople +
                ", reservationPay=" + reservationPay +
                ", reservationStatus='" + reservationStatus + '\'' +
                '}';
    }
}
