package com.codemind.whirlpool.employee_management.dto;

public class RewardData {
	private String cardKey;
	private String cardName;
	private String cardIssuer;
	private String cardNetwork;
	private String categoryType;
	private String spendBonusCategoryName;
	private long spendBonusCategoryId;
	private String spendBonusDesc;
	private double earnMultiplier;
	private String spendType;
	private int isDateLimit;
	private String limitBeginDate;
	private String limitEndDate;
	private int isSpendLimit;
	private long spendLimit;
	private String spendLimitResetPeriod;

	public String getCardKey() {
		return cardKey;
	}

	public void setCardKey(String cardKey) {
		this.cardKey = cardKey;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardIssuer() {
		return cardIssuer;
	}

	public void setCardIssuer(String cardIssuer) {
		this.cardIssuer = cardIssuer;
	}

	public String getCardNetwork() {
		return cardNetwork;
	}

	public void setCardNetwork(String cardNetwork) {
		this.cardNetwork = cardNetwork;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getSpendBonusCategoryName() {
		return spendBonusCategoryName;
	}

	public void setSpendBonusCategoryName(String spendBonusCategoryName) {
		this.spendBonusCategoryName = spendBonusCategoryName;
	}

	public long getSpendBonusCategoryId() {
		return spendBonusCategoryId;
	}

	public void setSpendBonusCategoryId(long spendBonusCategoryId) {
		this.spendBonusCategoryId = spendBonusCategoryId;
	}

	public String getSpendBonusDesc() {
		return spendBonusDesc;
	}

	public void setSpendBonusDesc(String spendBonusDesc) {
		this.spendBonusDesc = spendBonusDesc;
	}

	public double getEarnMultiplier() {
		return earnMultiplier;
	}

	public void setEarnMultiplier(double earnMultiplier) {
		this.earnMultiplier = earnMultiplier;
	}

	public String getSpendType() {
		return spendType;
	}

	public void setSpendType(String spendType) {
		this.spendType = spendType;
	}

	public int getIsDateLimit() {
		return isDateLimit;
	}

	public void setIsDateLimit(int isDateLimit) {
		this.isDateLimit = isDateLimit;
	}

	public String getLimitBeginDate() {
		return limitBeginDate;
	}

	public void setLimitBeginDate(String limitBeginDate) {
		this.limitBeginDate = limitBeginDate;
	}

	public String getLimitEndDate() {
		return limitEndDate;
	}

	public void setLimitEndDate(String limitEndDate) {
		this.limitEndDate = limitEndDate;
	}

	public int getIsSpendLimit() {
		return isSpendLimit;
	}

	public void setIsSpendLimit(int isSpendLimit) {
		this.isSpendLimit = isSpendLimit;
	}

	public long getSpendLimit() {
		return spendLimit;
	}

	public void setSpendLimit(long spendLimit) {
		this.spendLimit = spendLimit;
	}

	public String getSpendLimitResetPeriod() {
		return spendLimitResetPeriod;
	}

	public void setSpendLimitResetPeriod(String spendLimitResetPeriod) {
		this.spendLimitResetPeriod = spendLimitResetPeriod;
	}
}
