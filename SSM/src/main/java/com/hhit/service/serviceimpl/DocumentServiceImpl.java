package com.hhit.service.serviceimpl;

import com.hhit.dao.DocumentDao;
import com.hhit.model.Document;
import com.hhit.model.Page;
import com.hhit.service.DocumentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="documentService")
public class DocumentServiceImpl implements DocumentService {

    @Resource
    DocumentDao documentDao;
    @Override
    public void addDocument(Document document) {
        documentDao.addDocument(document);
    }

    @Override
    public List<Document> documentSearchall() {
        return documentDao.documentSearchall();
    }

    @Override
    public void deletedocument(int id) {
        documentDao.deletedocument(id);
    }

    @Override
    public List<Document> searchdocList(Page page) {
        return documentDao.searchdocList(page);
    }

    @Override
    public Integer searchTotalCount(Page page) {
        return documentDao.searchTotalCount(page);
    }

    @Override
    public List<Document> getdocBycondtion(Page page) {
        return documentDao.getdocBycondtion(page);
    }
}


