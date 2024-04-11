package com.assetmanagement.desklite.asset.models;

import com.assetmanagement.desklite.base.jpaauditing.Auditable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "fixedasset")
public class FixedAssetModel extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1302238787758825035L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String color;
	private String graphicsCard;
	private String ram;
	private String rom;
	private String processor;
	private String os ;
	private String osversion;
	private String battery;
	private String chargerType;
	private String wireless;
	private String weight;
	private String dimension;
	private String ipaddress;
	private String connectorType;
	private String blutoothVersion;
	private String chargingTime;
	private String capacity;
	private String size;
	private String watts;
	private String material;
	private String volt;
	private String length;
	private String simNumber;
	private String imeiNumber;
	private String generation;
	
	@OneToOne
	private AssetModel assetModel;
	
	

}
