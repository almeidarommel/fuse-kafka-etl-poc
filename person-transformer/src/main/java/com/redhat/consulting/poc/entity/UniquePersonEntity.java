package com.redhat.consulting.poc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_processed")
public class UniquePersonEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8560392639182026717L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="id_postgres")
	private Integer idPostgres;
	
	@Column(name="id_mysql")
	private Integer idMysql;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cellphone")
	private String cellPhone;
	
	@Column(name="social_security")
	private String socialSecurity;
	
	@Column(name="create_date")
	private Date created_on;
	
	@Column(name="update_date")
	private Date last_update;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPostgres() {
		return idPostgres;
	}

	public void setIdPostgres(Integer idPostgres) {
		this.idPostgres = idPostgres;
	}

	public Integer getIdMysql() {
		return idMysql;
	}

	public void setIdMysql(Integer idMysql) {
		this.idMysql = idMysql;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

}
