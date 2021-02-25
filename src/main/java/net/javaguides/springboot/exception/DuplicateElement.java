package net.javaguides.springboot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class DuplicateElement extends RuntimeException {
	public DuplicateElement() {
		super("ja existe");
	}
}
