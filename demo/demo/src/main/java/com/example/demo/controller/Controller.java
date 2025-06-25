package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.odel;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@org.springframework.stereotype.Controller
public class Controller {

	
	@GetMapping("doc")
	@ResponseBody
	String getReort(HttpServletResponse resonse) throws JRException, IOException
	{
		List<odel> l = new ArrayList<>();
		odel od= new odel();
		od.setCITY("jhf");
		od.setFIRSTNAME("jkkk");
		od.setId(122);
		od.setLASTNAME("jhjhjh");
		od.setSTREET("fjgjjg");
		l.add(od);
		String ath= "C:\\Users\\user\\Downloads\\demo\\demo\\src\\main\\resources\\re.jrxml";
		String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "re.jrxml").getAbsolutePath();
		JasperReport report = JasperCompileManager.compileReport(sourceFileName);
		
		JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(l);
		JasperPrint rnt = JasperFillManager.fillReport(report, null,data);
		
		 JRXlsxExporter exporter = new JRXlsxExporter();
	        SimpleXlsxReportConfiguration reportConfigXLS = new SimpleXlsxReportConfiguration();
	        reportConfigXLS.setSheetNames(new String[] { "sheet1" });
	        exporter.setConfiguration(reportConfigXLS);
	        exporter.setExporterInput(new SimpleExporterInput(rnt));
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(resonse.getOutputStream()));
	        resonse.setHeader("Content-Disposition", "attachment;filename=jasperReport.xlsx");
	        resonse.setContentType("application/octet-stream");
	        exporter.exportReport();
		return "ok";
	}
}
