package lab5.xyzrentalcars.app.importacao;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.IndexOptions;
import com.monitorjbl.xlsx.StreamingReader;
import lab5.xyzrentalcars.util.MongoConnectionFactory;
import org.apache.poi.ss.usermodel.*;
import org.bson.Document;
import org.json.JSONArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class LeadImport {
    private final String file;
    private final boolean hasHeaderRow;
    private final List<String> headers = new ArrayList<>();
    private final JSONArray output = new JSONArray();

    public LeadImport(boolean hasHeaderRow){
        file = null;
        this.hasHeaderRow = hasHeaderRow;
    }

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

    public void toMongo(String file){
        var index = file.lastIndexOf("\\");
        var db_sufix = file.substring(index + 1, index + 3);
        MongoDatabase database = MongoConnectionFactory.getDatabase("base-leads");
        MongoCollection<Document> collection = database.getCollection("leads-"+db_sufix);

        collection.createIndex(new Document("cpf", 1), new IndexOptions().unique(true));

        try(InputStream is = new FileInputStream(file);
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)
                .bufferSize(1024)
                .open(is)){
            Sheet sheet = workbook.getSheetAt(0);
            int numRows = sheet.getLastRowNum();
            int rowIndex = 0;
            System.out.println("Importando " + numRows + " linhas.");
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                String key;
                Document doc = new Document();
                print(file, rowIndex, numRows);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
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
                            doc.append(key, cell.getNumericCellValue());
                            break;
                        case STRING:
                            doc.append(key, cell.getStringCellValue().trim());
                            break;
                        case BLANK:
                            doc.append(key, "");
                            break;
                        case ERROR:
                            doc.append(key, cell.getErrorCellValue());
                            break;
                        case BOOLEAN:
                            doc.append(key, cell.getBooleanCellValue());
                            break;
                    }
                }
                try{
                    collection.insertOne(doc);
                }catch(MongoWriteException e){ }
                rowIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(String file, int index, int length){
        String progressbar = "";
        int progress = 100*index/length;
        for(int i = 0; i < progress; i++){
            progressbar += "=";
        }
        System.out.printf("%s: [%s>] %d%%", file, progressbar, progress);
        if(progress < 100){
            System.out.printf("\r");
        } else {
            System.out.printf("\n");
        }
    }
}
