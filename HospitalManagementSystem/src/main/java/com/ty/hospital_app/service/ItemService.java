package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.ItemDaoImp;
import com.ty.hospital_app.dto.Item;

public class ItemService {
	public void saveItem(Item item,int mid) {
		ItemDaoImp idi=new ItemDaoImp();
		Item item1=idi.saveItem(mid, item);
		if(item1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public Item getItem(int iid) {
		ItemDaoImp idi=new ItemDaoImp();
		Item item=idi.getItemById(iid);
		if(item!=null) {
			return item;
		}
		else {
			return null;
		}
	}
	
	public void deleteItem(int iid) {
		ItemDaoImp idi=new ItemDaoImp();
		boolean flag=idi.deleteItemById(iid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public Item updateItemById(int iid,Item item) {
		ItemDaoImp idi=new ItemDaoImp();
		Item item1=idi.updateItemById(iid, item);
		if(item1!=null) {
			return item1;
		}
		else {
			return null;
		}
	}
	
	public List<Item> getAllItems(){
		ItemDaoImp idi=new ItemDaoImp();
		List<Item> items=idi.getAllItems();
		return items;
	}
}
