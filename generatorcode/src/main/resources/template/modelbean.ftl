package ${Paramss.packageNameStr};
<#--导包 -->
<#list Paramss.importStrs as importStr>
import ${importStr};
</#list>
<#if Paramss.beanContent!="">
    /*
     *${Paramss.beanContent}
     *
     */
</#if>
public class ${Paramss.beanName} {
 
<#--属性生成 -->
<#list Paramss.columns as _column>
    /*
     *${_column.propertComment}
     *
     */
    private ${_column.propertType} ${_column.propertName};
</#list>
<#list Paramss.columns as _column>

    public ${_column.propertType} get${_column.propertNameUpCase}(){
        return ${_column.propertName};
    }
    
    public void set${_column.propertNameUpCase}(${_column.propertType} ${_column.propertName}s){
        this.${_column.propertName} = ${_column.propertName}s;
    }
</#list>
<#--构造函数-->
    public ${Paramss.beanName}(){
     	super();
	}
	@Override
	public String toString() {
		return "${Paramss.beanName} ["+
		<#list Paramss.columns as _column>
		  "${_column.propertName}="+${_column.propertName}+","
		</#list>
		  + "]";
	}
}