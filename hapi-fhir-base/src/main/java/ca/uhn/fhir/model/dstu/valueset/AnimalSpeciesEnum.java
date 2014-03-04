
package ca.uhn.fhir.model.dstu.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum AnimalSpeciesEnum {

	/**
	 * canislf
	 * Dog
	 *
	 * Canis lupus familiaris
	 */
	CANISLF("canislf"),
	
	/**
	 * ovisa
	 * Sheep
	 *
	 * Ovis aries
	 */
	OVISA("ovisa"),
	
	/**
	 * serinuscd
	 * Domestic Canary
	 *
	 * Serinus canaria domestica
	 */
	SERINUSCD("serinuscd"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/animal-species
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/animal-species";

	/**
	 * Name for this Value Set:
	 * AnimalSpecies
	 */
	public static final String VALUESET_NAME = "AnimalSpecies";

	private static Map<String, AnimalSpeciesEnum> CODE_TO_ENUM = new HashMap<String, AnimalSpeciesEnum>();
	private String myCode;
	
	static {
		for (AnimalSpeciesEnum next : AnimalSpeciesEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
		}
	}
	
	/**
	 * Returns the code associated with this enumerated value
	 */
	public String getCode() {
		return myCode;
	}
	
	/**
	 * Returns the enumerated value associated with this code
	 */
	public AnimalSpeciesEnum forCode(String theCode) {
		AnimalSpeciesEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<AnimalSpeciesEnum> VALUESET_BINDER = new IValueSetEnumBinder<AnimalSpeciesEnum>() {
		@Override
		public String toCodeString(AnimalSpeciesEnum theEnum) {
			return theEnum.getCode();
		}
		
		@Override
		public AnimalSpeciesEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
	};
	
	/** 
	 * Constructor
	 */
	AnimalSpeciesEnum(String theCode) {
		myCode = theCode;
	}

	
}