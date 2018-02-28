package com.hyjcy.oa.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.DiningRecord;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DiningAction extends ModelDrivenBaseAction<DiningRecord> {
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private int count;//用餐人数
	private String date;
	private List<DiningRecord> todayList = null;
	private List<DiningRecord> hisList = null;
	private List<DiningRecord> dayList = null;
	private List<DiningRecord> recordAmList = null;
	private List<DiningRecord> recordPmList = null;
	
	public List<DiningRecord> getRecordAmList() {
		return recordAmList;
	}

	public void setRecordAmList(List<DiningRecord> recordAmList) {
		this.recordAmList = recordAmList;
	}

	public List<DiningRecord> getRecordPmList() {
		return recordPmList;
	}

	public void setRecordPmList(List<DiningRecord> recordPmList) {
		this.recordPmList = recordPmList;
	}

	public List<DiningRecord> getDayList() {
		return dayList;
	}

	public void setDayList(List<DiningRecord> dayList) {
		this.dayList = dayList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public List<DiningRecord> getTodayList() {
		return todayList;
	}

	public void setTodayList(List<DiningRecord> todayList) {
		this.todayList = todayList;
	}

	public List<DiningRecord> getHisList() {
		return hisList;
	}

	public void setHisList(List<DiningRecord> hisList) {
		this.hisList = hisList;
	}
	
	
	public String index() throws Exception{
		return "index";
	}
	

	public String cancel() throws Exception{//下饭牌
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(new Date());
		
		Date am = sdf.parse("11:00:00");
		
		if (sdf.parse(now).after(am)) {
			return "timeOut";
		}
		
		diningService.cancel();
		return "cancelSuccess";
	}
	
	
	public String book() throws Exception{//订餐
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(new Date());
		
		Date pm = sdf.parse("16:00:00");
		
		if (sdf.parse(now).after(pm)) {
			return "timeOut";
		}
		
		diningService.book();
		return "bookSuccess";
	}
	
	
	public String statistics() throws Exception{//统计当天用餐人数
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(new Date());
		
		try {
			//此时间节点作为分割线，14：:00前统计中餐用餐人数，14：:00后统计晚餐用餐人数
			Date flag = sdf.parse("14:00:00");
			
			if (sdf.parse(now).before(flag)) {
				count = diningService.statistics_am();
			}else {
				count = diningService.statistics_pm();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		return "statistics";
	}
	
	
	public String list() throws Exception{//查看当天用餐人的信息列表
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(new Date());
		
		try {
			//此时间节点作为分割线，14：:00前统计中餐用餐人数，14：:00后统计晚餐用餐人数
			Date flag = sdf.parse("14:00:00");
			
			if (sdf.parse(now).before(flag)) {
				todayList = diningService.list_am();
			}else {
				todayList = diningService.list_pm();
			}
			ActionContext.getContext().getValueStack().push(todayList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "list";
	}
	
	public String record() throws Exception{//查看订餐历史记录
		dayList = diningService.record();
		ActionContext.getContext().getValueStack().push(dayList);
		/*for (DiningRecord iterable_element : dayList) {
			System.out.println(iterable_element.getDay());
		}*/
		return "record";
	}
	
	public String recordAmList() throws Exception{//查看订餐历史记录中餐详情
		recordAmList = diningService.record_am_list(date);
		ActionContext.getContext().getValueStack().push(recordAmList);
		/*for (DiningRecord iterable_element : recordAmList) {
			System.out.println(iterable_element.getDiner().getName());
		}*/
		System.out.println(date);
		System.out.println("record_am_list");
		return "recordAm";
	}
	
	public String recordPmList() throws Exception{//查看订餐历史记录晚餐详情
		recordPmList = diningService.record_pm_list(date);
		ActionContext.getContext().getValueStack().push(recordPmList);
		/*for (DiningRecord iterable_element : recordPmList) {
			System.out.println(iterable_element.getDiner().getName());
		}*/
		System.out.println(date);
		System.out.println("record_pm_list");
		return "recordPm";
	}
}
