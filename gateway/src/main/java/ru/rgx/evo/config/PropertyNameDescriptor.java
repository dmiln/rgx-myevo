package ru.rgx.evo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "property")
@ConfigurationPropertiesScan
public class PropertyNameDescriptor {
	private String name;
}
