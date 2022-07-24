package com.car.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.IAppointmentRepository;
import com.car.dao.IOrderRepository;
import com.car.dao.IPaymentRepository;
import com.car.exception.NoPaymentFoundException;
import com.car.models.Appointment;
import com.car.models.Order;
import com.car.models.Payment;

@Service
public class IPaymentServiceImp implements IPaymentService {
	
	@Autowired
	private IPaymentRepository payrepo;
	
	@Autowired
	private IAppointmentRepository iappo;
	
	@Autowired
	private IOrderRepository orrepo;

	@Override
	public Payment addPayment(Payment payment) {
		payrepo.save(payment);
		return payment;
	}

	@Override
	public void removePayment(long id) {
		if(payrepo.existsById(id)) {
			List<Appointment> res = iappo.findByPaymentNotNull();
			List<Order> or = orrepo.findByPaymentNotNull();
			for(Order r:or) {
				if(r.getPayment().getPaymentId()==id) {
					r.setPayment(null);
					orrepo.save(r);
				}
			}
			
			for(Appointment r:res) {
				if(r.getPayment().getPaymentId()==id) {
					r.setPayment(null);
					iappo.save(r);				}
			}
			payrepo.deleteById(id);

		}
			else {
				throw new NoPaymentFoundException();
			}
		
		
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		Payment pay = getpayRec(id);
		if(pay != null)
		{
			pay.setPaymentId(payment.getPaymentId());
			pay.setStatus(payment.getStatus());
			pay.setType(payment.getType());
			pay.setCard(payment.getCard());
			payrepo.save(pay);
		}
		return pay;
	}

	@Override
	public Payment getPaymentDetails(long id) {
		return payrepo.findByPaymentId(id);
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		return payrepo.findAll();
		
	}
	
	public Payment getpayRec(long id) {
        Optional<Payment> payObj = payrepo.findById(id);
        if (payObj.isPresent()) {
        	System.out.println("present");
            return payObj.get();
            
        }
        return null;
    }

}