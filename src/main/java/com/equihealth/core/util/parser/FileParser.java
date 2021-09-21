package com.equihealth.core.util.parser;

import com.equihealth.core.model.FileReferenceData;

import java.io.IOException;
import java.util.List;

public interface FileParser {

    public List<FileReferenceData> readFile(String filename) throws IOException;
}
