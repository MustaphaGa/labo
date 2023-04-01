package com.form.org.interceptor;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor{
	
	private static final long serialVersionUID = 1L;

	@Override
	  public String onPrepareStatement(String sql) {
	    if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
	      final String entityName = sql.substring(7, sql.indexOf("."));
	      final String idLabo =MDC.get("idLabo");
	      if (StringUtils.hasLength(entityName)
	    		  && !entityName.toLowerCase().contains("labo")
	    		  && !entityName.toLowerCase().contains("profil")
	    		  && StringUtils.hasLength(idLabo) ){
	    	  if (sql.contains("where")) {
	              sql = sql + " and " + entityName + ".idLabo = " + idLabo;
	            } else {
	              sql = sql + " where " + entityName + ".idLabo = " + idLabo;
	            }
	      }
	    }
	     return super.onPrepareStatement(sql);
	  }

	 }