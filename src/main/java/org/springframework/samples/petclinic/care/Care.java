package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Care {
	@Id
	Integer id;
	
    String name;
    String description;
    Set<PetType> compatiblePetTypes;
}
