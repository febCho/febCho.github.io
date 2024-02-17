package kr.spring.ch11.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import kr.spring.ch11.vo.PageRank;

public class PageRanksView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
									Workbook workbook, 
									HttpServletRequest request,
									HttpServletResponse response) throws Exception {
		//sheet 생성
		HSSFSheet sheet = createFirstSheet((HSSFWorkbook)workbook);
		//레이블 생성
		createColumnLabel(sheet);
		//각 행의 셀에 데이터 표시
		int rowNum = 1;
		List<PageRank> pageRanks = (List<PageRank>)model.get("pageRanks");
		for(PageRank rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++);
		}
		
		//다운로드 파일명 지정
		String fileName = "pageRanks2024.xls";
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
	}
	
	//sheet 생성
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
						//sheet index, 이름
		workbook.setSheetName(0, "페이지 순위");
		//특정 컬럼에 넓이 지정
						//column index, width
		sheet.setColumnWidth(1, 256*20);
		return sheet;
	}
	
	//컬럼 레이블 생성
	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("순위");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("페이지");
	}
	
	//하나의 행이 가지고 있는 셀들에 내용 표시
	private void createPageRankRow(HSSFSheet sheet, PageRank rank,
								int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());//만들어진 행의 첫번째 셀엔 순위
		
		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());//만들어진 행의 두번째 셀엔 페이지
	}
}
