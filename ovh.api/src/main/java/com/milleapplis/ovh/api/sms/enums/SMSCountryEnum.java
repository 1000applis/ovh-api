package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSCountryEnum {
	AG("ag"),
	AI("ai"),
	ALL("all"),
	AN("an"),
	AR("ar"),
	AT("at"),
	AU("au"),
	AW("aw"),
	BA("ba"),
	BB("bb"),
	BE("be"),
	BG("bg"),
	BH("bh"),
	BM("bm"),
	BO("bo"),
	BR("br"),
	BZ("bz"),
	CH("ch"),
	CL("cl"),
	CN("cn"),
	CO("co"),
	CR("cr"),
	CU("cu"),
	CY("cy"),
	CZ("cz"),
	DE("de"),
	DK("dk"),
	DM("dm"),
	DZ("dz"),
	EC("ec"),
	EE("ee"),
	EG("eg"),
	ES("es"),
	FI("fi"),
	FR("fr"),
	GB("gb"),
	GD("gd"),
	GP("gp"),
	GR("gr"),
	GY("gy"),
	HK("hk"),
	HN("hn"),
	HR("hr"),
	HT("ht"),
	HU("hu"),
	ID("id"),
	IE("ie"),
	IL("il"),
	IN("in"),
	IS("is"),
	IT("it"),
	JM("jm"),
	JO("jo"),
	JP("jp"),
	KR("kr"),
	KW("kw"),
	KY("ky"),
	LB("lb"),
	LC("lc"),
	LT("lt"),
	LU("lu"),
	LV("lv"),
	MA("ma"),
	ME("me"),
	MQ("mq"),
	MS("ms"),
	MT("mt"),
	MY("my"),
	NC("nc"),
	NG("ng"),
	NL("nl"),
	NO("no"),
	NZ("nz"),
	PA("pa"),
	PE("pe"),
	PF("pf"),
	PH("ph"),
	PK("pk"),
	PL("pl"),
	PT("pt"),
	PY("py"),
	RE("re"),
	RO("ro"),
	RS("rs"),
	RU("ru"),
	SA("sa"),
	SE("se"),
	SG("sg"),
	SI("si"),
	SK("sk"),
	SR("sr"),
	TC("tc"),
	TH("th"),
	TN("tn"),
	TR("tr"),
	TT("tt"),
	TW("tw"),
	UA("ua"),
	UY("uy"),
	VC("vc"),
	VE("ve"),
	VG("vg"),
	VN("vn"),
	ZA("za");
	
	private String priority; 
	
	private SMSCountryEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSCountryEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSCountryEnum currentPriority : SMSCountryEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
