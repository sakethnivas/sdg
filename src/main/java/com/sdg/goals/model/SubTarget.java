package com.sdg.goals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="subtargets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubTarget {

	@Id
	@Column(name="SubtargetId")
	private int subtargetid;
	
	
	@Column(name="SubtargetName")
	private String subtargetname;
	
	@Column(name ="SubtargetDescription")
	private String subtargetdescription;
	@Column(name="Status")
	private String status;
	
	@Column(name ="SubtargetUnits")
	private String subtargetUnits;
	

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "target_id")
    @JsonIgnore
    private Target target;

	
	
	
	public Target getTarget() {
		return target;
	}



	public void setTarget(Target target) {
		this.target = target;
	}
	public void setTargetid(int targetId) {
	    this.target.setTargetid(targetId);
	}



	public SubTarget() {
		super();
		// TODO Auto-generated constructor stub
	}



	public SubTarget(String subtargetname, String subtargetdescription,String status, String subtargetUnits, Target target) {
		super();
		this.subtargetname = subtargetname;
		this.subtargetdescription = subtargetdescription;
		this.status=status;
		this.subtargetUnits = subtargetUnits;
		this.target = target;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getSubtargetid() {
		return subtargetid;
	}



	public void setSubtargetid(int subtargetid) {
		this.subtargetid = subtargetid;
	}



	public String getSubtargetname() {
		return subtargetname;
	}



	public void setSubtargetname(String subtargetname) {
		this.subtargetname = subtargetname;
	}



	public String getSubtargetdescription() {
		return subtargetdescription;
	}



	public void setSubtargetdescription(String subtargetdescription) {
		this.subtargetdescription = subtargetdescription;
	}



	public String getSubtargetUnits() {
		return subtargetUnits;
	}



	public void setSubtargetUnits(String subtargetUnits) {
		this.subtargetUnits = subtargetUnits;
	}



	@Override
	public String toString() {
		return "SubTarget [subtargetid=" + subtargetid + ", subtargetname=" + subtargetname + ", subtargetdescription="
				+ subtargetdescription + ", status=" + status + ", subtargetUnits=" + subtargetUnits + ", target="
				+ target + "]";
	}



	

	
	

	
	
	
}
