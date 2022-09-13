
package dani.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuditableProvider {

	private String auditable;

	@Autowired
	public AuditableProvider(@Value("${auditable:false}") String auditable) {
		log.debug(auditable);
		this.auditable = auditable;
	}

	public boolean is() {
		return Boolean.valueOf(auditable);
	}

}
