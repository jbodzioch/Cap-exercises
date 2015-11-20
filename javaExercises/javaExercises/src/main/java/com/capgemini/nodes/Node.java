package com.capgemini.nodes;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node {

	private String id;
	private String description;
	private String predecessorId;

	public String getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPredecessorId() {
		return this.predecessorId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPredecessorId(String predecessorId) {
		this.predecessorId = predecessorId;
	}

	public Node(String id, String description, String predecessorId) {

		setId(id);
		setDescription(description);
		setPredecessorId(predecessorId);
	}

}
