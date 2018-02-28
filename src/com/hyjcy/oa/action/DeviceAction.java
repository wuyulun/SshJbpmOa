package com.hyjcy.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.Device;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DeviceAction extends ModelDrivenBaseAction<Device> {

	private List<Device> deviceInfo = null;
	
	
	public List<Device> getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(List<Device> deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
	
	
	public String list() {
		System.out.println(getCurrentUser().getName());
		if (getCurrentUser().getName().equals("叶冠林")) {
			deviceInfo = deviceService.allInfo();
			ActionContext.getContext().getValueStack().push(deviceInfo);
			return "alldevice";
		}
			
		deviceInfo = deviceService.myInfo();
		ActionContext.getContext().getValueStack().push(deviceInfo);
		return "mydevice";
	}
	
	public String addDeviceUI(){
		
		return "addUI";
	}
	
	public String editDeviceUI(){
		Device device = deviceService.getById(model.getId());
		System.out.println("id=" + model.getId());
		ActionContext.getContext().getValueStack().push(device);
		return "editUI";
	}
	
	public String addDevice() {
		// TODO Auto-generated method stub
		Device device = new Device();
		device.setType(model.getType());
		device.setBrand(model.getBrand());
		device.setModel(model.getModel());
		device.setParameter(model.getParameter());
		device.setPossessor(model.getPossessor());
		device.setDepartment(model.getDepartment());
		device.setBuytime(model.getBuytime());
		deviceService.addDevice(device);
		return "adddevice";
	}
	
	public String editDevice(){
		Device device = deviceService.getById(model.getId());
		device.setType(model.getType());
		device.setBrand(model.getBrand());
		device.setModel(model.getModel());
		device.setParameter(model.getParameter());
		device.setPossessor(model.getPossessor());
		device.setDepartment(model.getDepartment());
		
		deviceService.update(device);
		return "editdevice";
	}
	
	public String deleteDevice() {
		deviceService.delete(model.getId());
		return "deletedevice";
	}
}
