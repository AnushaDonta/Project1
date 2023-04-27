package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.MedOrder;

public interface MedOrderDao {
	MedOrder saveMedOrder(int eid,MedOrder medOrder);
	MedOrder getMedOrderById(int mid);
	boolean deleteMedOrderById(int mid);
	MedOrder updateMedOrderById(int mid,MedOrder medOrder);
	List<MedOrder> getAllMedOrders();
	List<MedOrder> getMedOrdersByDoctorName(String dname);
	List<MedOrder> getMedOrdersByDate(String date);
}
