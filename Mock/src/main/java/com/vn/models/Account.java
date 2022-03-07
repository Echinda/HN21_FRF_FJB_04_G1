package com.vn.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @GenericGenerator(
            name = "account_seq", 
            strategy = "com.vn.models.IdGenerator",
            parameters = { 
                    @Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = IdGenerator.CODE_NUMBER_SEPARATOR_PARAMETER, value = "_"), 
                    @Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Column(name = "account_id")
	private String accountId;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;
	
	@Column(name = "date_of_birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateOfBirth;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;
	
	@Column(name = "gender", length = 255, nullable = false)
	private String gender;
	
	@Column(name = "identity_card", length = 255, nullable = false)
	private String identityCard;
	
	@Column(name = "image", length = 255, nullable = false)
	private String image;
	
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@Column(name = "phone_number", length = 255, nullable = false)
	private String phoneNumber;
	
	@Column(name = "register_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date registerDate;
	
	@Column(name = "status", nullable = false)
	private Integer status;
	
	@Column(name = "user_name", length = 255, nullable = false)
	private String userName;
	
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role;
}
