package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.repository.UserRepository;
import com.ust.rest.resource.Product;
import com.ust.rest.resources.User;



@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	public Product getProduct(long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	/* public Product getProduct(long productID) */
	/*	{
			return repository.getProduct(productID);
		}
		
		public ArrayList<Product> getProducts(){
			return repository.getProducts();
		}*/
	public List<Product> getProducts()
	{
		return productRepository.findAll();
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Product add(Product product) {

		Product productT=productRepository.save(product);
		
		return productT;
		
		
	}
	
	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public boolean addUser() {
		User user=new User();
		user.setUserId(5L);
		user.setDateTime(System.currentTimeMillis()+"767676767676767676 ");
		try {
			User userT = userRepository.save(user);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return true;
	}
	
//	
//	public ArrayList<Product> getProducts()
//	{
//		return repository.getProducts();
//	}
//
//	@Transactional
//public Product add(Product product)
//{	
////		if (validate(product))
////		{
////			return false;
////		}
////	else
////		{
////		productRepository.save(product);
////		 return true;
////	}
//		
//		Product productT = productRepository.save(product);
//		User user = new User();
//		user.setUserId(5L);
//		user.setDateTime(System.currentTimeMillis()+"7676767676");
//		User userT = userRepository.save(user);
//		System.out.println(userT);
//		if(userT!=null && productT!=null)
//			return true;
//		else
//			throw new RuntimeException("record not inserted");
//}
	
	
public boolean validate(Product product)
{
	if(product.getName().equals("Phone"))
	{
		return true;
	}
	else
	{
		return false;
	}
	
}
public Product updateProduct(Product product)
{
	return productRepository.save(product);
}
//	public Product updateProduct(Product product)
//	{
//		return repository.updateProduct(product);
//	}
//	

public void deleteProduct(long productId)
{
	 productRepository.deleteById(productId);
}

//	public void deleteProduct(long productId)
//	{
//		 repository.delete(productId);
//	}
//	
	

}

