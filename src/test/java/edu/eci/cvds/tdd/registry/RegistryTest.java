package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;
public class RegistryTest {
	
private Registry registry = new Registry();

@Test
public void validateRegistryResult() {
	Person person = new Person("Daniel", 1, 21, Gender.MALE, true);
	RegisterResult result = registry.registerVoter(person);
	Assert.assertEquals(RegisterResult.VALID, result);
	}

// TODO Complete with more test cases

@Test
public void deadRegistryResult() {
	Person person = new Person("Natalia", 2, 18, Gender.FEMALE, false);
	RegisterResult result = registry.registerVoter(person);
	Assert.assertEquals(RegisterResult.DEAD, result);
	}

@Test
public void invalidateAgeRegistryResult() {
	Person person = new Person("Vanessa", 3, 101, Gender.FEMALE, true);
	RegisterResult result = registry.registerVoter(person);
	Assert.assertEquals(RegisterResult.INVALID_AGE, result);
	}

@Test
public void underAgeRegistryResult() {
	Person person = new Person("Andrés", 4, 10, Gender.UNIDENTIFIED, true);
	RegisterResult result = registry.registerVoter(person);
	Assert.assertEquals(RegisterResult.UNDERAGE, result);
	}

@Test
public void duplicatedRegistryResult() {
	Person person = new Person("Esteban", 5, 23,Gender.UNIDENTIFIED, true);
	Person personTwo = new Person("Esteban", 5, 23,Gender.UNIDENTIFIED, true);
	RegisterResult result = registry.registerVoter(person);
	RegisterResult resultTwo = registry.registerVoter(personTwo);
	Assert.assertEquals(RegisterResult.DUPLICATED, resultTwo);
	}
}

