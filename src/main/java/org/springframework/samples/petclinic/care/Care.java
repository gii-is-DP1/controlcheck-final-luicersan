package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="care")
public class Care {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull
	@Column(unique=true)
	@Size(min = 5, max = 50)
    String name;
	
	@NotNull
    String description;
    
	@NotEmpty
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "care_pet_type",
            joinColumns =@JoinColumn(name = "care_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_type_id"))
    private Set<PetType> compatiblePetTypes;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "incompatible_cares",
    joinColumns =@JoinColumn(name = "first_care_id"),
    inverseJoinColumns = @JoinColumn(name = "second_care_id"))
	private Set<Care> incompatibleCares;
}
