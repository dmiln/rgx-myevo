package ru.rgx.evo.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PropertyNameDescriptor.class)
class PropertyNameDescriptorTest {

	@Autowired
	private PropertyNameDescriptor propertyNameDescriptor;
	
	@Test
	void shouldGetNotNull() {
		assertThat(propertyNameDescriptor).isNotNull();
	}
	
	@Test
	void shouldGetCorrectPropertyNameValue() {
		String name = propertyNameDescriptor.getName();
		assertEquals("some_table_name", name);
	}

}
