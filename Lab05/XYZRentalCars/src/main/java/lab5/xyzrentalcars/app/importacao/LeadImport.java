package lab5.xyzrentalcars.app.importacao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.monitorjbl.xlsx.StreamingReader;
import lab5.xyzrentalcars.util.MongoConnectionFactory;
import org.apache.poi.ss.usermodel.*;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeadImport {
    private final String file;
    private final boolean hasHeaderRow;
    private final List<String> headers = new ArrayList<>();
    private final JSONArray output = new JSONArray();

    public LeadImport(String file) {
        this.file = file;
        hasHeaderRow = true;
    }

    public LeadImport(String file, boolean hasHeaderRow) {
        this.file = file;
        this.hasHeaderRow = hasHeaderRow;
    }

    public String getFile() {
        return file;
    }

    public boolean isHasHeaderRow() {
        return hasHeaderRow;
    }

    public String getHeader(int index) {
        return headers.get(index);
    }

    public JSONArray getOutput() {
        return output;
    }

    private void toJson() {
        //List<Lead> listaLead = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(
                    getClass()
                            .getClassLoader()
                            .getResource(file)
                            .getFile());

            Workbook workbook = WorkbookFactory.create(arquivo);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getCell(0).getRowIndex() == 1000) {
                    break;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                //Lead lead = new Lead();
                //listaLead.add(lead);
                String key;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.printf("row: %d | col: %d\n", cell.getRowIndex(), cell.getColumnIndex());
                    if (hasHeaderRow && cell.getRowIndex() == 0) {
                        headers.add(cell.getStringCellValue());
                        continue;
                    } else if (hasHeaderRow) {
                        key = headers.get(cell.getColumnIndex());
                    } else {
                        key = String.valueOf(cell.getColumnIndex());
                    }
                    JSONObject output = new JSONObject();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            output.put(key, cell.getNumericCellValue());
                            break;
                        case STRING:
                            output.put(key, cell.getStringCellValue());
                            break;
                        case BLANK:
                            output.put(key, "");
                            break;
                        case ERROR:
                            output.put(key, cell.getErrorCellValue());
                            break;
                        case BOOLEAN:
                            output.put(key, cell.getBooleanCellValue());
                            break;
                    }
                    this.output.put(output);
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toMongo(){
        MongoDatabase database = MongoConnectionFactory.getDatabase("base_demais_convenios");
        MongoCollection collection = database.getCollection("base");
        try(InputStream is = new FileInputStream(
                        getClass()
                                .getClassLoader()
                                .getResource(file)
                                .getFile());
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)
                .bufferSize(4096)
                .open(is)){
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                String key;
                Document doc = new Document();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.printf("row: %d | col: %d\n", cell.getRowIndex(), cell.getColumnIndex());
                    if (hasHeaderRow && cell.getRowIndex() == 0) {
                        headers.add(cell.getStringCellValue());
                        continue;
                    } else if (hasHeaderRow) {
                        key = headers.get(cell.getColumnIndex());
                    } else {
                        key = String.valueOf(cell.getColumnIndex());
                    }

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            doc.put(key, cell.getNumericCellValue());
                            break;
                        case STRING:
                            doc.put(key, cell.getStringCellValue());
                            break;
                        case BLANK:
                            doc.put(key, "");
                            break;
                        case ERROR:
                            doc.put(key, cell.getErrorCellValue());
                            break;
                        case BOOLEAN:
                            doc.put(key, cell.getBooleanCellValue());
                            break;
                    }
                }
                collection.insertOne(doc);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
