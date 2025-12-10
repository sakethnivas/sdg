package com.sdg.goals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONFIG_PARAM")
public class ConfigParam {
	@Id
	@Column 
	private String configkey;
	@Column
	private String configvalue;
	public ConfigParam() {
		super();
	}
	public ConfigParam(String configkey, String configvalue) {
		super();
		this.configkey = configkey;
		this.configvalue = configvalue;
	}
	public String getConfigkey() {
		return configkey;
	}
	public void setConfigkey(String configkey) {
		this.configkey = configkey;
	}
	public String getConfigvalue() {
		return configvalue;
	}
	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

}
