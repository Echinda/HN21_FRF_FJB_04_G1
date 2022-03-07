package com.vn.models;

import java.io.Serializable;
import java.util.Date;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Range;

import com.vn.models.idgenerator.IdGenerator;

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
            strategy = "com.vn.models.idgenerator.IdGenerator",
            parameters = { 
                    @Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = IdGenerator.CODE_NUMBER_SEPARATOR_PARAMETER, value = "_"), 
                    @Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Column(name = "account_id")
	private String accountId;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;
	
	@NotBlank(message = "Date of birth is mandatory")
	@Column(name = "date_of_birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Email
	@NotBlank(message = "Email is mandatory")
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@NotBlank(message = "Full name is mandatory")
	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;
	
	@Range(min = 0, max = 1)
	@Column(name = "gender", length = 255, nullable = false)
	private String gender;
	
	@Column(name = "identity_card", length = 255, nullable = false)
	private String identityCard;
	
	@Column(name = "image", length = 255, nullable = false)
	private String image;
	
	@NotBlank(message = "Password is mandatory")
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@NotBlank(message = "Phone number is mandatory")
	@Column(name = "phone_number", length = 255, nullable = false)
	private String phoneNumber;
	
	@Column(name = "register_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
	@NotBlank(message = "Status is mandatory")
	@Column(name = "status", nullable = false)
	private Integer status;
	
	@NotBlank(message = "Username is mandatory")
	@Column(name = "user_name", length = 255, nullable = false, unique = true)
	private String username;
	
	@NotBlank(message = "Role ID is mandatory")
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role;
}
