package com.hyjcy.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.Car;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class CarAction extends ModelDrivenBaseAction<Car> {

	private List<Car> carInfo = null;
	
	public List<Car> getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(List<Car> carInfo) {
		this.carInfo = carInfo;
	}

	public String list(){
		carInfo = carService.list();
		ActionContext.getContext().getValueStack().push(carInfo);
		return "list";
	}
	
	public String addCarUI(){
		
		return "addUI";
	}
	
	public String editCarUI(){
		Car car = carService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(car);
		return "editUI";
	}
	
	public String addCar() {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setBrand(model.getBrand());
		car.setSeat(model.getSeat());
		car.setNumber(model.getNumber());
		car.setBuytime(model.getBuytime());
		carService.save(car);
		return "addcar";
	}
	
	public String editCar(){
		Car car = carService.getById(model.getId());
		System.out.println(model.getId());
		car.setBrand(model.getBrand());
		car.setSeat(model.getSeat());
		car.setNumber(model.getNumber());
		car.setBuytime(model.getBuytime());
		carService.update(car);
		return "editcar";
	}
	
	public String deleteCar(){
		carService.delete(model.getId());
		return "deletecar";
	}
}
