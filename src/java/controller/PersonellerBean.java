package controller;

import DAO.PersonellerDAO;
import entity.Personeller;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class PersonellerBean implements Serializable {

    private PersonellerDAO dao;
    private Personeller entity;

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

    public String create() {
        this.getDao().insert(entity);
        return "/panel/personeller/create";
    }

    public List<Personeller> getRead() {
        return this.getDao().list(page, pageSize);
    }

    public String updateForm(Personeller personel) {
        this.entity = personel;
        return "/panel/personeller/update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/panel/personeller/list";
    }

    public void delete(Personeller personel) {
        this.getDao().delete(personel);
    }

    public PersonellerDAO getDao() {
        if (this.dao == null) {
            this.dao = new PersonellerDAO();
        }
        return dao;
    }

    public void setDao(PersonellerDAO dao) {
        this.dao = dao;
    }

    public Personeller getEntity() {
        if (this.entity == null) {
            this.entity = new Personeller();
        }
        return entity;
    }

    public void setEntity(Personeller entity) {

        this.entity = entity;
    }
}
