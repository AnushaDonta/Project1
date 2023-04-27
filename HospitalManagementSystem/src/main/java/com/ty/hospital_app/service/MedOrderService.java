package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.MedOrderDaoImp;
import com.ty.hospital_app.dto.MedOrder;

public class MedOrderService {
	public void saveMedOrder(MedOrder medOrder,int eid) {
		MedOrderDaoImp mdi=new MedOrderDaoImp();
		MedOrder medOrder1=mdi.saveMedOrder(eid, medOrder);
		if(medOrder1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public MedOrder getMedOrder(int mid) {
		MedOrderDaoImp mdi=new MedOrderDaoImp();
		MedOrder medOrder=mdi.getMedOrderById(mid);
		if(medOrder!=null) {
			return medOrder;
		}
		else {
			return null;
		}
	}
	
	public void deleteMedOrder(int mid) {
		MedOrderDaoImp mdi=new MedOrderDaoImp();
		boolean flag=mdi.deleteMedOrderById(mid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public MedOrder updateMedOrderById(int mid,MedOrder medOrder) {
		MedOrderDaoImp mdi=new MedOrderDaoImp();
		MedOrder medOrder1=mdi.updateMedOrderById(mid, medOrder);
		if(medOrder1!=null) {
			return medOrder1;
		}
		else {
			return null;
		}
	}
	
	public List<MedOrder> getAllMedOrders(){
		MedOrderDaoImp mdi=new MedOrderDaoImp();
		List<MedOrder> medOrders=mdi.getAllMedOrders();
		return medOrders;
	}
	
	public List<MedOrder> getMedOrdersByDoctorName(String dname){
		MedOrderDaoImp mdi=new MedOrderDaoImp();
		List<MedOrder> medOrders=mdi.getMedOrdersByDoctorName(dname);
		return medOrders;
	}
	
	public List<MedOrder> getMedOrdersByDate(String date){
		MedOrderDaoImp mdi=new MedOrderDaoImp();
		List<MedOrder> medOrders=mdi.getMedOrdersByDate(date);
		return medOrders;
	}
}
