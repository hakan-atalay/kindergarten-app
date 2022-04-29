package controller;

import DAO.EtkinliklerDAO;
import entity.Etkinlikler;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class EtkinliklerBean implements Serializable {

    private EtkinliklerDAO dao;
    private Etkinlikler entity;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (this.page == 1) {
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
        return "/panel/etkinlikler/create";
    }

    public List<Etkinlikler> getRead() {
        return this.getDao().list(page, pageSize);
    }

    public String updateForm(Etkinlikler etkinlik) {
        this.entity = etkinlik;
        return "/panel/etkinlikler/update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/panel/etkinlikler/list";
    }

    public void delete(Etkinlikler etkinlik) {
        this.getDao().delete(etkinlik);
    }

    public EtkinliklerDAO getDao() {
        if (this.dao == null) {
            this.dao = new EtkinliklerDAO();
        }
        return dao;
    }

    public void setDao(EtkinliklerDAO dao) {
        this.dao = dao;
    }

    public Etkinlikler getEntity() {
        if (this.entity == null) {
            this.entity = new Etkinlikler();
        }
        return entity;
    }

    public void setEntity(Etkinlikler entity) {

        this.entity = entity;
    }

}
