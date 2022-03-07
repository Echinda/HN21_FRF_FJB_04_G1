package com.vn.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.vn.models.idgenerator.InvoiceIdGenerator;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
    @GenericGenerator(
            name = "invoice_seq", 
            strategy = "com.vn.models.idgenerator.InvoiceIdGenerator",
            parameters = { 
                    @Parameter(name = InvoiceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = InvoiceIdGenerator.CODE_NUMBER_SEPARATOR_PARAMETER, value = "_"), 
                    @Parameter(name = InvoiceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Column(name = "invoice_id")
	private String invoiceId;
	
	@NotBlank(message = "Add Score is mandatory")
	@Column(name = "add_score", nullable = false)
	private Integer addScore;
	
	@NotBlank(message = "Booking date is mandatory")
	@Column(name = "booking_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;
	
	@NotBlank(message = "Movie name is mandatory")
	@Column(name = "movie_name", length = 255, nullable = false)
	private String movieName;
	
	@NotBlank(message = "Schedule Show is mandatory")
	@Column(name = "schedule_show", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date scheduleShow;
	
	@NotBlank(message = "Schedule showtime is mandatory")
	@Column(name = "schedult_show_time", length = 255, nullable = false)
	private String scheduleShowTime;
	
	@NotBlank(message = "Status is mandatory")
	@Column(name = "status", nullable = false)
	private Integer status;
	
	@NotBlank(message = "Total money is mandatory")
	@Column(name = "total_money", nullable = false, precision = 19)
	private Double totalMoney;
	
	@NotBlank(message = "Use Score is mandatory")
	@Column(name = "use_score", nullable = false)
	private Integer useScore;
	
	@NotBlank(message = "Seat is mandatory")
	@Column(name = "seat", length = 255, nullable = false)
	private String seat;
}
