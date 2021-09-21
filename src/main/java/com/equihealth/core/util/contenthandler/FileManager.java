package com.equihealth.core.util.contenthandler;

import com.equihealth.core.model.FileReferenceData;
import com.equihealth.core.util.parser.FileParser;
import com.equihealth.core.util.parser.JsonParser;
import java.io.IOException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FileManager implements PriceContentManager {

  // holds the context to switch the reader/ using json for poc"
  private FileParser fileParser;


  @Override
  public List<FileReferenceData> readContent(String fileName) throws IOException {
    return loadRefData(fileName);
  }

  public List<FileReferenceData> loadRefData(String fileName) throws IOException {
     fileParser = new JsonParser();
    return fileParser.readFile(fileName);

  }


}
