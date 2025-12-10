package com.sdg.goals.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="targets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Target {

	@Id
	@Column(name="TargetId")
	private int targetid;
	

	@Column(name="TargetName",columnDefinition ="VARCHAR(1024)")
	private String targetname;
	
	@Column(name="TargetDescription",columnDefinition ="VARCHAR(1024)")
	private String targetdescription;
	
	public Target(String targetname, String targetdescription, Goal goal, List<SubTarget> subtargets) {
		super();
		this.targetname = targetname;
		this.targetdescription = targetdescription;
		this.goal = goal;
		this.subtargets = subtargets;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goal_id")
    @JsonIgnore
    private Goal goal;
	
	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	@OneToMany(mappedBy = "target", cascade = CascadeType.ALL, orphanRemoval = true)

	  private List<SubTarget> subtargets=new ArrayList<>();
		

		public List<SubTarget> getSubtargets() {
			return subtargets;
		}

		public void setSubtargets(List<SubTarget> subtargets) {
			this.subtargets = subtargets;
		}

	
	public Target() {
		
	}
	public Target(Goal goal) {
        this.goal = goal;
    }
	

	public int getTargetid() {
		return targetid;
	}

	


	public void setTargetid(int targetid) {
		this.targetid = targetid;
	}

	
	public String getTargetname() {
		return targetname;
	}

	public void setTargetname(String targetname) {
		this.targetname = targetname;
	}

	
	public void setGoalid(int goalId) {
	    this.goal.setGoalid(goalId);
	}

	

	public String getTargetdescription() {
		return targetdescription;
	}

	public void setTargetdescription(String targetdescription) {
		this.targetdescription = targetdescription;
	}

	

	@Override
	public String toString() {
		return "Target [targetid=" + targetid + ", targetname=" + targetname + ", targetdescription="
				+ targetdescription + "]";
	}

	public void setTarget(Target target) {
		
	}

	

	
		 
}
