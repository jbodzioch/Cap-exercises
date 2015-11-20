package com.capgemini.nodes;

import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li>
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {

	private final int VALID_ID_LENGTH = 4;
	private final int MAX_DESCRIPTION_LENGTH = 128;

	public void validateMethod(List<Node> nodes) {

		checkId(nodes);
		checkDescription(nodes);
		checkCycle(nodes);
		checkMultipleSubsequent(nodes);
	}

	public boolean checkId(List<Node> nodes) {

		boolean idChecker = true;

		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getId().length() != VALID_ID_LENGTH) {
				idChecker = false;
			}
		}

		return idChecker;
	}

	public boolean checkDescription(List<Node> nodes) {

		boolean descriptionChecker = true;

		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getDescription().length() > MAX_DESCRIPTION_LENGTH) {
				descriptionChecker = false;
			}
		}

		return descriptionChecker;
	}

	public boolean checkCycle(List<Node> nodes) {

		boolean cycleChecker = true;

		for (int i = 0; i < nodes.size(); i++) {
			if (Integer.parseInt(nodes.get(i).getId()) <= Integer.parseInt(nodes.get(i).getPredecessorId())) {
				cycleChecker = false;
			}
		}

		return cycleChecker;
	}

	public boolean checkMultipleSubsequent(List<Node> nodes) {

		boolean multipleSubsequentChecker = true;

		for (int i = 0; i < nodes.size() - 1; i++) {
			for (int j = i + 1; j < nodes.size(); j++) {
				if (haveSameParent(nodes.get(i), nodes.get(j)) && isNotPenultimate(nodes, nodes.get(i))) {
					multipleSubsequentChecker = false;
				}
			}
		}

		return multipleSubsequentChecker;
	}

	private boolean haveSameParent(Node node1, Node node2) {

		boolean result = false;

		if (node1.getPredecessorId() == node2.getPredecessorId()) {
			result = true;
		}

		return result;
	}

	private boolean isNotPenultimate(List<Node> nodes, Node node) {

		boolean result = false;

		if (node.getPredecessorId() != nodes.get(nodes.size() - 2).getPredecessorId()) {
			result = true;
		}

		return result;
	}
}
