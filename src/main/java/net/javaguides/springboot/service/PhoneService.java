package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Phone;

public interface PhoneService {
	Phone createPhone(Phone phone);

	Phone updatePhone(Phone phone);

	List<Phone> getAllPhone();

	Phone getPhoneById(long phoneId);

	void deletePhone(long id);
}
