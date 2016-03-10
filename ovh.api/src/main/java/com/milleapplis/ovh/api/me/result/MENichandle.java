package com.milleapplis.ovh.api.me.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.me.enums.MEApplicationStatusEnum;
import com.milleapplis.ovh.api.me.enums.MELanguageEnum;
import com.milleapplis.ovh.api.me.enums.MELegalFormEnum;
import com.milleapplis.ovh.api.me.enums.MEStateEnum;
import com.milleapplis.ovh.api.me.enums.MEOvhCompanyEnum;
import com.milleapplis.ovh.api.me.enums.MEOvhSubsidiaryEnum;
import com.milleapplis.ovh.api.me.enums.MEGenderEnum;

public class MENichandle {

	@JsonProperty
	private String firstname;
	@JsonProperty
	private String vat;
	@JsonProperty
	private MEOvhSubsidiaryEnum ovhSubsidiary;
	@JsonProperty
	private String area;
	@JsonProperty
	private String birthDay;
	@JsonProperty
	private String nationalIdentificationNumber;
	@JsonProperty
	private String spareEmail;
	@JsonProperty
	private MEOvhCompanyEnum ovhCompany;
	@JsonProperty
	private MEStateEnum state;
	@JsonProperty
	private String email;
	@JsonProperty
	private MECurrency currency;
	@JsonProperty
	private String city;
	@JsonProperty
	private String fax;
	@JsonProperty
	private String nichandle;
	@JsonProperty
	private String address;
	@JsonProperty
	private String companyNationalIdentificationNumber;
	@JsonProperty
	private String birthCity;
	//TODO change country into enum
	@JsonProperty
	private String country;
	//TODO change language into enum
	@JsonProperty
	private MELanguageEnum language;
	@JsonProperty
	private String organisation;
	@JsonProperty
	private String name;
	@JsonProperty
	private String phone;
	@JsonProperty
	private MEGenderEnum sex;
	@JsonProperty
	private String zip;
	@JsonProperty
	private String corporationType;
	@JsonProperty
	private MELegalFormEnum legalform;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public MEOvhSubsidiaryEnum getOvhSubsidiary() {
		return ovhSubsidiary;
	}
	public void setOvhSubsidiary(MEOvhSubsidiaryEnum ovhSubsidiary) {
		this.ovhSubsidiary = ovhSubsidiary;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getNationalIdentificationNumber() {
		return nationalIdentificationNumber;
	}
	public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
		this.nationalIdentificationNumber = nationalIdentificationNumber;
	}
	public String getSpareEmail() {
		return spareEmail;
	}
	public void setSpareEmail(String spareEmail) {
		this.spareEmail = spareEmail;
	}
	public MEOvhCompanyEnum getOvhCompany() {
		return ovhCompany;
	}
	public void setOvhCompany(MEOvhCompanyEnum ovhCompany) {
		this.ovhCompany = ovhCompany;
	}
	public MEStateEnum getState() {
		return state;
	}
	public void setState(MEStateEnum state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MECurrency getCurrency() {
		return currency;
	}
	public void setCurrency(MECurrency currency) {
		this.currency = currency;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNichandle() {
		return nichandle;
	}
	public void setNichandle(String nichandle) {
		this.nichandle = nichandle;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanyNationalIdentificationNumber() {
		return companyNationalIdentificationNumber;
	}
	public void setCompanyNationalIdentificationNumber(
			String companyNationalIdentificationNumber) {
		this.companyNationalIdentificationNumber = companyNationalIdentificationNumber;
	}
	public String getBirthCity() {
		return birthCity;
	}
	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public MELanguageEnum getLanguage() {
		return language;
	}
	public void setLanguage(MELanguageEnum language) {
		this.language = language;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public MEGenderEnum getSex() {
		return sex;
	}
	public void setSex(MEGenderEnum sex) {
		this.sex = sex;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCorporationType() {
		return corporationType;
	}
	public void setCorporationType(String corporationType) {
		this.corporationType = corporationType;
	}
	public MELegalFormEnum getLegalform() {
		return legalform;
	}
	public void setLegalform(MELegalFormEnum legalform) {
		this.legalform = legalform;
	}
	
	
	
	
	
	
}
