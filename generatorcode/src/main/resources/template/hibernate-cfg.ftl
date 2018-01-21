<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<!-- 
    自动生成hibernate 配置文件
-->
<hibernate-mapping>
		<!-- 默认hql-->
	<#if cfgPram.HqlModel ??>
	<!-- 默认hql-->
	<query name="${cfgPram.HqlModel.hqlName}">    
         <![CDATA[    
             ${cfgPram.HqlModel.hql}   
         ]]> 
     </query>
	</#if>
     <#if cfgPram.SqlModel ?? >
	<!-- 默认sql-->
     <sql-query name="${cfgPram.SqlModel.sqlName}">    
         <![CDATA[    
             ${cfgPram.SqlModel.sql}  
         ]]> 
         <return alias="${cfgPram.SqlModel.alias}" class="${cfgPram.SqlModel.className}"/>    
     </sql-query>
	</#if>
        
    <!--列名对应关系 -->
    <class name="${cfgPram.cfgClassName}" table="${cfgPram.cfgTableName}" catalog="${cfgPram.cfgTableCatlog}">
   	  <#list cfgPram.cfgProperty as cfp>
   	  <#if cfp.columnName??>
   	  <#if cfgPram.cfgTablePk??>
   	  	<#if cfp.columnName == cfgPram.cfgTablePk>
   	  	 <id name="${cfp.propertyName}" type="${cfp.propertyType}">
            <column name="${cfp.columnName}" length="${cfp.columnNameLength}" />
            <comment>${cfp.comment}</comment>
            <generator class="assigned" />
        </id>
   	  	</#if>
   	  	</#if>
   	  	</#if>
   	  	<property name="${cfp.propertyName}" type="${cfp.propertyType}">
   	  	<#if cfp.propertyType =="java.lang.Double">
   	  	  <column name="${cfp.columnName}" precision="${cfp.columnNameLength}" scale="${cfp.doubleScale}" />
   	  	<#else>
            <column name="${cfp.columnName}" length="${cfp.columnNameLength}" />
         </#if>
            <comment>${cfp.comment}</comment>
        </property>
   	  </#list>
    </class>
</hibernate-mapping>
