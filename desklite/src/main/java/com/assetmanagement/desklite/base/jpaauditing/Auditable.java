package com.assetmanagement.desklite.base.jpaauditing;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable{
	 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@CreatedBy
    public String createdBy;
	
    @CreatedDate

    public LocalDateTime creationDate;
    
    @LastModifiedBy
    public String lastModifiedBy;
    
    @LastModifiedDate
   
    public LocalDateTime lastModifiedDate;

}
