package com.assetmanagement.desklite.asset.models;

import java.util.Locale.Category;

import com.assetmanagement.desklite.asset.enums.AssetType;
import com.assetmanagement.desklite.asset.enums.OperationalStatus;
import com.assetmanagement.desklite.asset.enums.Status;
import com.assetmanagement.desklite.base.jpaauditing.Auditable;
import com.assetmanagement.desklite.login.models.CompanyDetailsModel;
import com.assetmanagement.desklite.login.models.EmployeeModel;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "asset")
public class AssetModel extends Auditable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8526807757120956682L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assetId;
	private String assetName;
	private String description;
	private String serialNumber;
	private String modelNumber;
	private String brand;
	private double cost;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Enumerated(EnumType.STRING)
	private OperationalStatus operationalStatus;
	@Enumerated(EnumType.STRING)
	private AssetType assetType;
	@Enumerated(EnumType.STRING)
	
	
	@ManyToOne
	@JoinColumn
	private CompanyDetailsModel company;
 
	@ManyToOne
	@JoinColumn
	private EmployeeModel employee;
	
	@OneToOne
	private AssetModel assetModel;

}
