package com.vn.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String PREFIX_CODE = "ACC_";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;
	
	@NotBlank(message = "Role name is mandatory")
	@Column(name = "role_name", length = 255, nullable = false)
	private String roleName;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<Account> accounts;
	
	public String getCode() {
		String code = null;
		switch (this.roleId) {
		//Admin
		case 3:
			code = PREFIX_CODE + "A";
			break;
		//Employee
		case 2:
			code = PREFIX_CODE + "E";
			break;
		//Member
		default:
			code = PREFIX_CODE + "M";
			break;
		}
		return code;
	}
}
