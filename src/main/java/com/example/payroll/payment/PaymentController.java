package com.example.payroll.payment;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.payroll.request.GetPayRequest;
import com.example.payroll.request.PayRequest;
import com.example.payroll.response.GetPayResponse;
import com.example.payroll.response.PayResponse;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	private static final String SUCCESS_STATUS = "success";
	
    private static final String ERROR_STATUS = "error";
    
    private static final int CODE_SUCCESS = 200;
    
    private static final int CODE_FAILURE = 500;
    
    @Autowired
	private PaymentRepository repository;
    
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public PayResponse pay(@RequestBody PayRequest request) {
    	PayResponse response = new PayResponse();
        
        Payment payment = new Payment();
        
        UUID uuid = UUID. randomUUID();
        payment.setId(uuid);
        
        payment.setUserId(request.getUserId());
        payment.setItemId(request.getItemId());
        payment.setAmount(request.getAmount());
        payment.setTotal(request.getTotal());
        
        try {
        	repository.save(payment);
        	
        	response.setUuid(uuid.toString());
        	response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);
        }catch(Exception e) {
        	logger.error(e.getMessage());
        	response.setStatus(ERROR_STATUS);
            response.setCode(CODE_FAILURE);
        }
        
        return response;
        
    }
    
    @SuppressWarnings("deprecation")
	@RequestMapping(value = "/getPay", method = RequestMethod.POST)
    public GetPayResponse getPayResponse(@RequestBody GetPayRequest request) {
    	GetPayResponse response = new GetPayResponse();
    	
    	try {
        	Payment payment = repository.getById(request.getUuid());
        	
        	response.setUserId(payment.getUserId());
        	response.setItemId(payment.getItemId());
        	response.setAmount(payment.getAmount());
        	response.setTotal(payment.getTotal());
        	
        	response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);
        }catch(Exception e) {
        	logger.error(e.getMessage());
        	response.setStatus(ERROR_STATUS);
            response.setCode(CODE_FAILURE);
        }
    	
    	return response;
    }

}
