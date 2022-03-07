package com.vn.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="invoice")
public class Invoice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "invoice_id")
	private String invoiceId;
	
	@Column(name = "add_score", nullable = false)
	private Integer addScore;
	
	@Column(name = "booking_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date bookingDate;
	
	@Column(name = "movie_name", length = 255, nullable = false)
	private String movieName;
	
	@Column(name = "schedule_show", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date scheduleShow;
	
	@Column(name = "schedult_show_time", length = 255, nullable = false)
	private String scheduleShowTime;
	
	@Column(name = "status", nullable = false)
	private Integer status;
	
	@Column(name = "total_money", nullable = false, precision = 19)
	private Double totalMoney;
	
	@Column(name = "use_score", nullable = false)
	private Integer useScore;
	
	@Column(name = "seat", length = 255, nullable = false)
	private String seat;
}
