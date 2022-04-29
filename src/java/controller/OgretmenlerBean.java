package controller;

import DAO.OgretmenlerDAO;
import entity.Ogretmenler;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class OgretmenlerBean implements Serializable {

    private OgretmenlerDAO dao;
    private Ogretmenler entity;

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

    public Ogretmenler getById(int id) {
        return this.getDao().getById(id);
    }

    public String create() {
        this.getDao().insert(entity);
        return "/panel/ogretmenler/create";
    }

    public List<Ogretmenler> getRead() {
        return this.getDao().list(page, pageSize);
    }

    public String updateForm(Ogretmenler ogretmen) {
        this.entity = ogretmen;
        return "/panel/ogretmenler/update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/panel/ogretmenler/list";
    }

    public void delete(Ogretmenler ogretmen) {
        this.getDao().delete(ogretmen);
    }

    public OgretmenlerDAO getDao() {
        if (this.dao == null) {
            this.dao = new OgretmenlerDAO();
        }
        return dao;
    }

    public void setDao(OgretmenlerDAO dao) {
        this.dao = dao;
    }

    public Ogretmenler getEntity() {
        if (this.entity == null) {
            this.entity = new Ogretmenler();
        }
        return entity;
    }

    public void setEntity(Ogretmenler entity) {

        this.entity = entity;
    }
}
