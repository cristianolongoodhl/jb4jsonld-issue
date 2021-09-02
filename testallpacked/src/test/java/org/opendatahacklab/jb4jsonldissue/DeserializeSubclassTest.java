/**
 * 
 */
package org.opendatahacklab.jb4jsonldissue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.opendatahacklab.jb4jsonldissue.model.ChildClassA;
import org.opendatahacklab.jb4jsonldissue.model.ParentClass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import cz.cvut.kbss.jsonld.ConfigParam;
import cz.cvut.kbss.jsonld.jackson.JsonLdModule;

/**
 * Expected behaviour is that the most specific class i returned when
 * deserializing
 * 
 * @author cristianolongo
 *
 */
public class DeserializeSubclassTest {

	public ObjectMapper jsonLdObjectMapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		// Here we register the JSON-LD serialization/deserialization module
		final JsonLdModule module = new JsonLdModule();
		// Package scan is important for polymorphic deserialization
		module.configure(ConfigParam.SCAN_PACKAGE, "org.opendatahacklab.jb4jsonldissue.model");
		objectMapper.registerModule(module);

		return objectMapper;
	}

	@Test
	public void shouldDeserializationReturnMostSpecificSubclass() throws JsonProcessingException {
		final ChildClassA a = new ChildClassA();
		a.setId("http://example.com/childa/a");
		final String serialized = "{\"@id\":\"http://example.com/childa/a\",\"@type\":[\"http://www.example.org/childa\",\"http://www.example.org/parent\",\"http://www.example.org/grandparent\"]}";
		final ObjectReader r = jsonLdObjectMapper().readerFor(ParentClass.class);
		final ParentClass deserialized = r.readValue(serialized);
		assertEquals(a.getId(), deserialized.getId());
		assertTrue(deserialized instanceof ChildClassA);
	}
}
