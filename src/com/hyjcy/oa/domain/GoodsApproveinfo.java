package com.hyjcy.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class GoodsApproveinfo {
	private Long id;
	private String goodapproveTime;//审批时间
	private boolean gapproval; // 是否通过
	private String comment; // 审批意见
	private User goodapprover;//申请人
	private Goodsform goodsform;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGoodapproveTime() {
		return goodapproveTime;
	}
	public void setGoodapproveTime(String goodapproveTime) {
		this.goodapproveTime = goodapproveTime;
	}
	public boolean isGapproval() {
		return gapproval;
	}
	public void setGapproval(boolean gapproval) {
		this.gapproval = gapproval;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getGoodapprover() {
		return goodapprover;
	}
	public void setGoodapprover(User goodapprover) {
		this.goodapprover = goodapprover;
	}
	public Goodsform getGoodsform() {
		return goodsform;
	}
	public void setGoodsform(Goodsform goodsform) {
		this.goodsform = goodsform;
	}
	
}
