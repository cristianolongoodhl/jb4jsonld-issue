package org.opendatahacklab.jb4jsonldissue.model;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;

@OWLClass(iri = "http://www.example.org/childa")
public class ChildClassA extends ParentClass implements Serializable {

}