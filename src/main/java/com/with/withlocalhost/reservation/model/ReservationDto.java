package com.with.withlocalhost.reservation.model;

import java.util.Date;

public class ReservationDto {
    private int reservationId;
    private int tourId;
    private String reservater;
    private Date startDate;
    private Date endDate;
    private int reservationPeople;
    private int reservationPay;
    private String reservationStatus;

    // 기본 생성자
    public ReservationDto() {}

    // 모든 필드를 초기화하는 생성자
    public ReservationDto(int reservationId, int tourId, String reservater, Date startDate, Date endDate,
                          int reservationPeople, int reservationPay, String reservationStatus) {
        this.reservationId = reservationId;
        this.tourId = tourId;
        this.reservater = reservater;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationPeople = reservationPeople;
        this.reservationPay = reservationPay;
        this.reservationStatus = reservationStatus;
    }

    // Getter와 Setter
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

    // toString 메서드
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
