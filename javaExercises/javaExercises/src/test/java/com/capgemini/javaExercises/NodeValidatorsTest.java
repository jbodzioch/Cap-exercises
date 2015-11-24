package com.capgemini.javaExercises;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.nodes.Node;
import com.capgemini.nodes.NodeValidators;

public class NodeValidatorsTest {

	private NodeValidators validators = new NodeValidators();
	private List<Node> nodes;

	@Before
	public void initialize() {

		nodes = new ArrayList<Node>();
		nodes.add(new Node("1234", "desc", "1233"));
		nodes.add(new Node("1235", "desc", "1234"));
		nodes.add(new Node("1236", "desc", "1235"));
		nodes.add(new Node("1237", "desc", "1236"));
		nodes.add(new Node("1238", "desc", "1237"));
		validators.validateMethod(nodes);
	}

	@Test
	public void shouldReturnTrueForDefaultId() {

		boolean actual = validators.checkId(nodes);

		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseForInvalidId() {

		nodes.get(0).setId("010");

		boolean actual = validators.checkId(nodes);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnTrueForDefaultDescription() {

		boolean actual = validators.checkDescription(nodes);

		assertTrue(actual);
	}

	@Test
	public void shouldReturnTrueForValidDescription() {

		nodes.get(0).setDescription("this is a short description");

		boolean actual = validators.checkDescription(nodes);

		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseForInvalidDescription() {

		nodes.get(0)
				.setDescription("this is a loooooooooooooooooooo" + "oooooooooooooooooooo" + "oooooooooooooooooooo"
						+ "oooooooooooooooooooo" + "oooooooooooooooooooo" + "oooooooooooooooooooo"
						+ "oooooooooooooooooooo" + "oooooooooooooooooooo" + "oooooooooooooooooooo description");

		boolean actual = validators.checkDescription(nodes);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnTrueForDefaultCycle() {

		boolean actual = validators.checkCycle(nodes);

		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseForInvalidCycle() {

		nodes.get(0).setPredecessorId(nodes.get(nodes.size() - 1).getId());

		boolean actual = validators.checkCycle(nodes);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnTrueForDefaultMultiply() {

		boolean actual = validators.checkMultipleSubsequent(nodes);

		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseForInvalidMultiply() {

		nodes.get(1).setPredecessorId(nodes.get(0).getPredecessorId());

		boolean actual = validators.checkMultipleSubsequent(nodes);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnTrueForInvalidPenultimateMultiply() {

		nodes.get(0).setPredecessorId(nodes.get(nodes.size() - 2).getPredecessorId());

		boolean actual = validators.checkMultipleSubsequent(nodes);

		assertTrue(actual);
	}
}
