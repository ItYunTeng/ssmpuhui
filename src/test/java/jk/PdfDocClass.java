/**
 * 
 */
package jk;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.PrintService;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * @author ItYunTeng
 * @descrip 
 * @createDate 2018年8月27日
 * @return 
 */
public class PdfDocClass {
	static String  templatePath;
	
	static {
		String path = PrintService.class.getResource("/").getPath();//得到工程名WEB-INF/classes/路径
		path=path.substring(1, path.indexOf("classes"));
		templatePath = path+"config/template/print/template.pdf";
	}
	public void downNotice(OutputStream out) throws IOException, DocumentException {
		PdfReader reader = new PdfReader(templatePath);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		/* 将要生成的目标PDF文件名称 */
		PdfStamper ps = new PdfStamper(reader, bos);
		PdfContentByte under = ps.getUnderContent(1);
		/* 使用中文字体 */
		BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
		fontList.add(bf);
		/* 取出报表模板中的所有字段 */
		AcroFields fields = ps.getAcroFields();
		fields.setSubstitutionFonts(fontList);
		fillData(fields, data());
		/* 必须要调用这个，否则文档不会生成的 */
		ps.setFormFlattening(true);
		ps.close();
	    //我们可以使用文件流去保存这个文件的，现在我是网络流去下载
		out.write(bos.toByteArray());
		out.flush();
		out.close();
		bos.close();
	}
	public void fillData(AcroFields fields, Map<String, String> data) throws IOException, DocumentException {
		for (String key : data.keySet()) {
			String value = data.get(key);
			fields.setField(key, value); // 为字段赋值,注意字段名称是区分大小写的
		}
	}
	/**
	 * 最后是从数据库获取数据的
	 * @return
	 */
	public Map<String, String> data() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "test");
		data.put("address", "第10000001号");
		return data;
	}

}
