package controller;

import DAO.FaturalarDAO;
import entity.Faturalar;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class FaturalarBean implements Serializable {

    private FaturalarDAO dao;
    private Faturalar entity;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String insert() {
        this.getDao().insert(entity);
        return "/panel/faturalar/list.xhtml";
    }

    public List<Faturalar> getRead() {
        return this.getDao().list(page, pageSize);
    }

    public String updateForm(Faturalar fatura) {
        this.entity = fatura;
        return "/panel/faturalar/update.xhtml";
    }

    public String update() {
        this.getDao().update(entity);
        return "/panel/faturalar/list";
    }

    public void delete(Faturalar fatura) {
        this.getDao().delete(fatura);
    }

    public FaturalarDAO getDao() {
        if (this.dao == null) {
            this.dao = new FaturalarDAO();
        }
        return dao;
    }

    public void setDao(FaturalarDAO dao) {
        this.dao = dao;
    }

    public Faturalar getEntity() {
        if (this.entity == null) {
            this.entity = new Faturalar();
        }
        return entity;
    }

    public void setEntity(Faturalar fatura) {

        this.entity = fatura;
    }
}
