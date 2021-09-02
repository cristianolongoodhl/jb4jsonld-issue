package org.opendatahacklab.jb4jsonldissue.model;

import java.io.Serializable;

import cz.cvut.kbss.jopa.model.annotations.OWLClass;

@OWLClass(iri = "http://www.example.org/childb")
public class ChildClassB extends ParentClass implements Serializable {

}