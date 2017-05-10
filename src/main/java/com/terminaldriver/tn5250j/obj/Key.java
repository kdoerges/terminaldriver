package com.terminaldriver.tn5250j.obj;

public enum Key{
	ATTENTION("[attn]"),
	SYSTEM_REQUEST("[sysreq]"),
	RESET("[reset]"),
	CLEAR("[clear]"),
	HELP("[help]"),
	PG_UP("[pgup]"),
	PG_DOWN("[pgdown]"),
	ROLL_LEFT("[rollleft]"),
	ROLL_RIGHT("[rollright]"),
	FIELD_EXIT("[fldext]"),
	FIELD_PLUS("[field+]"),
	FIELD_MINUS("[field-]"),
	BOF("[bof]"),
	ENTER("[enter]"),
	HOME("[home]"),
	INSERT("[insert]"),
	BACKSPACE("[backspace]"),
	BACKTAB("[backtab]"),
	UP("[up]"),
	DOWN("[down]"),
	LEFT("[left]"),
	RIGHT("[right]"),
	DELETE("[delete]"),
	TAB("[tab]"),
	EOF("[eof]"),
	ERASE_EOF("[eraseeof]"),
	ERASE_FIELD("[erasefld]"),
	F3("[pf3]"),
	F9("[pf9]"),
	F10("[pf10]"),
	F16("[pf16]");
	
	private String code;
	Key(final String code){this.code= code;}
	@Override
	public String toString(){return code;}
}