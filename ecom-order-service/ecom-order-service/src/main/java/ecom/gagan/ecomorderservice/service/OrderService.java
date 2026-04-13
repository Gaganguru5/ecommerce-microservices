package ecom.gagan.ecomorderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

	private final RestTemplate restTemplate;
	
	public OrderService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		
	}
	
	
	public String placeOrder(String productId) {
		
		System.out.println("in service: "+productId);
		String response = restTemplate.getForObject("http://localhost:8080/inventory/"+productId,String.class);
		System.out.println("respomse: "+response);
		
		// call inventory service to check stock if available place the order
		return "In Stock".equals(response)?"order placed successfully":"product is out of stock";
	}
}
