package com.bolsadeideas.springboot.app.view.xlsx;

import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Clase para combertir los detalles de la factura en excel
@Component("factura/ver.xlsx")
public class FacturaXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Nombre del archivo
		response.setHeader("Content-Disposition", "attachment; filename=\"factura_view.xlsx\"");

		Factura factura = (Factura) model.get("factura");

		Sheet sheet = workbook.createSheet("Factura Spring");

		// Primela fila
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);

		cell.setCellValue("Datos del Cliente");
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());

		row = sheet.createRow(2);
		cell = row.createCell(0);
		cell.setCellValue(factura.getCliente().getEmail());

		sheet.createRow(4).createCell(0).setCellValue("Datos de la factura");
		sheet.createRow(5).createCell(0).setCellValue("Folio: " + factura.getId());
		sheet.createRow(6).createCell(0).setCellValue("Descripcion: " + factura.getDescripcion());
		sheet.createRow(7).createCell(0).setCellValue("Fecha: " + factura.getCreateAt());

		CellStyle theaderStyle = workbook.createCellStyle();
		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		CellStyle tbodyStyle = workbook.createCellStyle();
		tbodyStyle.setBorderBottom(BorderStyle.THIN);
		tbodyStyle.setBorderTop(BorderStyle.THIN);
		tbodyStyle.setBorderRight(BorderStyle.THIN);
		tbodyStyle.setBorderLeft(BorderStyle.THIN);

		// Productos
		Row header = sheet.createRow(9);
		header.createCell(0).setCellValue("Producto");
		header.createCell(1).setCellValue("Precio");
		header.createCell(2).setCellValue("Cantidad");
		header.createCell(3).setCellValue("Total");

		header.getCell(0).setCellStyle(theaderStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);

		int rownum = 10;

		for (ItemFactura item : factura.getItems()) {
			Row fila = sheet.createRow(rownum++);

			// Aplicamos estilos
			cell = fila.createCell(0);
			cell.setCellValue(item.getProducto().getNombre());
			cell.setCellStyle(tbodyStyle);

			cell = fila.createCell(1);
			cell.setCellValue(item.getProducto().getPrecio());
			cell.setCellStyle(tbodyStyle);

			cell = fila.createCell(2);
			cell.setCellValue(item.getCantidad());
			cell.setCellStyle(tbodyStyle);

			cell = fila.createCell(3);
			cell.setCellValue(item.calcularImporte());
			cell.setCellStyle(tbodyStyle);

//			fila.createCell(0).setCellValue(item.getProducto().getNombre());
//			fila.createCell(1).setCellValue(item.getProducto().getPrecio());
//			fila.createCell(2).setCellValue(item.getCantidad());
//			fila.createCell(3).setCellValue(item.calcularImporte());
		}

		Row filaTotal = sheet.createRow(rownum);
		cell = filaTotal.createCell(2);
		cell.setCellValue("Gran Total: ");
		cell.setCellStyle(tbodyStyle);

		cell = filaTotal.createCell(3);
		cell.setCellValue(factura.getTotal());
		cell.setCellStyle(tbodyStyle);

		// filaTotal.createCell(2).setCellValue("Gran Total: ");
		// filaTotal.createCell(3).setCellValue(factura.getTotal());

	}

}
