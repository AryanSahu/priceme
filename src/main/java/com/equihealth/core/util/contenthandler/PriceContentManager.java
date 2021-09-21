package com.equihealth.core.util.contenthandler;

import com.equihealth.core.model.FileReferenceData;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface PriceContentManager {

  List<FileReferenceData> readContent(String fileName) throws IOException;


}
