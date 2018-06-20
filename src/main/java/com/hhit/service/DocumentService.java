package com.hhit.service;

import com.hhit.model.Document;
import com.hhit.model.Page;
import com.hhit.model.Student;

import java.util.List;

public interface DocumentService {
    void addDocument(Document document);
    List<Document> documentSearchall();
    void deletedocument(int id);
    List<Document> searchdocList(Page page);
    Integer searchTotalCount(Page page);
    List<Document> getdocBycondtion(Page page);
}
