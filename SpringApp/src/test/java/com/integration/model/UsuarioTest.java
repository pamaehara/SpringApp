package com.integration.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private static Validator validator;

	@Before
	public void setUp() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void nomeUsuarioIsNull() {
		Usuario usuario = new Usuario(1, null, "1234", new Date());

		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

		assertEquals(1, constraintViolations.size());
		assertEquals("não pode estar vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void nomeUsuarioIsEmpy() {
		Usuario usuario = new Usuario(1, "", "1234", new Date());
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		
		assertEquals(2, constraintViolations.size());
		List<String> erros = new ArrayList<String>(){{add("tamanho deve estar entre 3 e 255"); add("não pode estar vazio");}};
		constraintViolations.forEach(cv -> assertTrue(erros.contains(cv.getMessage())));
	}
	
	@Test
	public void nomeUsuarioSize() {
		Usuario usuario = new Usuario(1, "aa", "1234", new Date());
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		
		assertEquals(1, constraintViolations.size());
		assertEquals("tamanho deve estar entre 3 e 255", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void senhaIsNull() {
		Usuario usuario = new Usuario(1, "test", null, new Date());
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		
		assertEquals(1, constraintViolations.size());
		assertEquals("não pode estar vazio", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void senhaIsEmpy() {
		Usuario usuario = new Usuario(1, "test", "", new Date());
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		
		assertEquals(2, constraintViolations.size());
		List<String> erros = new ArrayList<String>(){{add("tamanho deve estar entre 3 e 255"); add("não pode estar vazio");}};
		constraintViolations.forEach(cv -> assertTrue(erros.contains(cv.getMessage())));
	}
	
	@Test
	public void senhaSize() {
		Usuario usuario = new Usuario(1, "test", "12", new Date());
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		
		assertEquals(1, constraintViolations.size());
		assertEquals("tamanho deve estar entre 3 e 255", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void usuarioIsValid() {
		Usuario usuario = new Usuario(1, "test", "1234", new Date());
		
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		
		assertEquals(0, constraintViolations.size());
	}
	
}
