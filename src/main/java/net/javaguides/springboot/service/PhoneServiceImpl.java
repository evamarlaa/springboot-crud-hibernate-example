package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Phone;
import net.javaguides.springboot.repository.PhoneRepository;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService{
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	
	@Override
	public Phone createPhone(Phone phone) {
		return phoneRepository.save(phone);
	}

	@Override
	public Phone updatePhone(Phone phone) {
		Optional<Phone> phoneDb = this.phoneRepository.findById(phone.getId());
		
		if(phoneDb.isPresent()) {
			Phone phoneUpdate = phoneDb.get();
			phoneUpdate.setId(phone.getId());
			phoneUpdate.setDdd(phone.getDdd());
			phoneUpdate.setNumber(phone.getNumber());
			phoneRepository.save(phone);
			return phoneUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + phone.getId());
		}		
	}

	@Override
	public List<Phone> getAllPhone() {
		return this.phoneRepository.findAll();
	}

	@Override
	public Phone getPhoneById(long phoneId) {
		
		Optional<Phone> phoneDb = this.phoneRepository.findById(phoneId);
		
		if(phoneDb.isPresent()) {
			return phoneDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + phoneId);
		}
	}

	@Override
	public void deletePhone(long phoneId) {
		Optional<Phone> phoneDb = this.phoneRepository.findById(phoneId);
		
		if(phoneDb.isPresent()) {
			this.phoneRepository.delete(phoneDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + phoneId);
		}
		
	}

}
