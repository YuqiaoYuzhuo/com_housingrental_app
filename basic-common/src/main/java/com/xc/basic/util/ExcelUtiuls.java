package com.xc.basic.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;


/**
 * <p>Title:Excel 的操作工具 </p> <p>Description: </p> 
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history: Created by WangLei 2017年2月22日
 */
@SuppressWarnings("deprecation")
public class ExcelUtiuls {
	/**
	 * <p>Description:将Excel转换成List<p>
	 * @param fis
	 * @return
	 * @author WangLei 2017年2月22日
	 */
	public static List<Map<String, String>> parseExcel(InputStream fis){
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		try {
			// 获取工作簿
			HSSFWorkbook hfb = new HSSFWorkbook(fis);
			// 获取第一个sheet
			HSSFSheet sheet = hfb.getSheetAt(0);
			int firstRow = sheet.getFirstRowNum();// 获取sheet的起始行数
			int lastRow = sheet.getLastRowNum(); // 获取sheet的末尾行数
			outer:for (int i = firstRow + 1; i < lastRow + 1; i++) {// 遍历获取每一行单元格列
				Map<String, String> dataMap = new HashMap<String, String>();
				HSSFRow row = sheet.getRow(i);
				int firstCell = row.getFirstCellNum();// 获取第i行的起始单元格数
				int lastCell = row.getLastCellNum();// 获取第i行的末尾单元格数
				for (int j = firstCell; j < lastCell; j++) {// 遍历每一个单元格
					HSSFCell hfcell = sheet.getRow(firstRow).getCell(j);// 获取一行的单元	
					if(null==hfcell){
						throw  new UtilsException( "模板出错！请确认是否修改模板格式！");
					}
					String key = hfcell.getStringCellValue();// 一般为表的属性名
					HSSFCell hfcell2 = row.getCell(j); // 获取第i行 第j个单元格
					if(null!=hfcell2){
						if (hfcell2.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {// 如果存在数字格式转为字符串
							hfcell2.setCellType(HSSFCell.CELL_TYPE_STRING);
						}
						String val = hfcell2.getStringCellValue();
						if(null!=val && StringUtils.isNotEmpty(val)){
							if(val.equals("end")){
								i=lastRow +1;
								continue outer;
							}
							dataMap.put(key, val);
						}
						else{
							throw new UtilsException("导入失败！第"+(i+1)+"行的"+key+"不能为空！");
						}
					}	
				}
					data.add(dataMap);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("---------------读取excel文件出错！");
			e.printStackTrace();
			throw  new UtilsException( "模板出错！");
		}

		return data;
	}
	/**
	 * <p>Description:导处excel格式文件<p>
	 * @param data 书籍
	 * @param title 标题
	 * @return
	 * @author WangLei 2017年2月22日
	 */
	public static HSSFWorkbook generateExcel(List<Map<String, String>> data,String title){
		HSSFWorkbook book = new HSSFWorkbook();
		if(null == data || data.size()<=0){
			return null;
		}
//			FileOutputStream fot = new FileOutputStream(desFile);
			HSSFSheet hsfs = book.createSheet("sheet1");// 创建sheet
			hsfs.setDefaultColumnWidth(20); 
			// 样式设置
			HSSFCellStyle style = book.createCellStyle();
			style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 头样式设置
			HSSFCellStyle style2 = book.createCellStyle();
			style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			// 设置上下左右边框
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成一个字体
			HSSFFont font = book.createFont();
			font.setFontHeightInPoints((short) 12);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			HSSFFont font2 = book.createFont();
			font2.setFontHeightInPoints((short) 11);
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			font2.setFontName("楷体");
			style2.setFont(font2);
			// 把字体应用到当前的样式
			style.setFont(font);
			// 填充表头标题
			int colSize = data.get(0).entrySet().size();
			System.out.println("size:" + colSize);
			// 合并单元格供标题使用(表名)
			hsfs.addMergedRegion(new CellRangeAddress(0, 0, 0, colSize - 1));
			HSSFRow firstRow = hsfs.createRow(0);// 第几行（从0开始）
			HSSFCell firstCell = firstRow.createCell(0);
			firstCell.setCellValue(title);
			firstCell.setCellStyle(style);
			// 填充表头header
			HSSFRow row = hsfs.createRow(1);
			Set<Entry<String, String>> set = data.get(0).entrySet();
			List<Entry<String, String>> l = new ArrayList<Map.Entry<String, String>>(set);
			for (int i = 0; i < l.size(); i++) { // 循环输入表头数据
				String key = l.get(i).getKey();
				System.out.println(key);
				HSSFCell cell = row.createCell(i);
				cell.setCellValue(key);
				cell.setCellStyle(style);
			}
			// 输入表格内容
			for (int i = 0; i < data.size(); i++) {
				HSSFRow row2 = hsfs.createRow(i + 2);// index：第几行
				Map<String, String> map = data.get(i);
				Set<Entry<String, String>> set2 = map.entrySet();
				List<Entry<String, String>> ll = new ArrayList<Entry<String, String>>(set2);
				for (int j = 0; j < ll.size(); j++) {
					String val = ll.get(j).getValue();
					HSSFCell cell = row2.createCell(j);// 第几列：从0开始
					cell.setCellValue(val);
					cell.setCellStyle(style2);
				}
			}
		//				book.write(fot); // 写入到excel
		//				fot.close();
		return book;
	}
	
//	public static void main(String[] args) {
////		导入测试
//		File f = new File("d:\\stu_template.xls");
//		InputStream isf;
//		List<Map<String,String>> data = null ;
//		try {
//			isf = new FileInputStream(f);
//			 data = ExcelUtiuls.parseExcel(isf);
//			 System.out.println(data);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		到处 
//		//ExcelUtiuls.generateExcel(data,"学生信息");
////		导入属性名转换实体类
////		String [] names = {"考生号","学号","姓名","身份证号"};
//	}
}
