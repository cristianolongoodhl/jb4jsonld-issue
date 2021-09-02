package org.opendatahacklab.jb4jsonldissue.model;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;

@OWLClass(iri = "http://www.example.org/parent")
public class ParentClass implements Serializable {
	@Id
	protected String id;

	public void setId(final String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}