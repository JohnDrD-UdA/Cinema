package com.cinema.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.test.DTO.RequestAuthDTO;
import com.cinema.test.model.Customer;
import com.cinema.test.repository.CustomerRepository;
import com.cinema.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public String createCustomer(Customer customer) {
		try { customerRepository.save(customer);
				return "creacion Exitosa";
			
		}
		catch(Exception e) {
			return "Error en la creacion";
			
		}
	}

	@Override
	public Customer queryUser(String userName) {
		 return customerRepository.findByUserName(userName);
	}

	@Override
	public String updateUser(Customer customerr) {
		Customer aux=customerRepository.findByUserName(customerr.getUserName());
		if(aux!=null) 
		{
			try {
				customerRepository.delete(aux);
				customerRepository.save(customerr);
				return "Exito en la actualizacion";
				
			}
			catch(Exception e) {
				return "error en actualizacion";
				
			}
		}
		return "Usuario no encontrado";
	}

	@Override
	public String deleteUser(String userName) {

		return deleteUser(customerRepository.findByUserName(userName));

	}

	@Override
	public String deleteUser(Customer customer) {
		try {
			customerRepository.delete(customer);
			return "Eliminacion Exitosa";
		}
		catch(Exception e) {
			return "Error en la eliminacion";
		}

	}

}
