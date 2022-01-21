package org.springframework.samples.petclinic.care;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="care_provision")
public class CareProvision {   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull
	@Min(0)
    double duration	;
	
	@ManyToOne(optional=true)
    @JoinColumn(name="visit_id")
    Visit visit;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="care_id")
    @NotNull
    Care care;   
}
