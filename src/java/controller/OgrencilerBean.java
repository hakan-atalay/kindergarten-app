package controller;

import DAO.OgrencilerDAO;
import DAO.OgretmenlerDAO;
import entity.Ogrenciler;
import entity.Ogretmenler;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class OgrencilerBean implements Serializable {

    private OgrencilerDAO dao;
    private Ogrenciler entity;
    private List<Ogretmenler> ogretmenList;
    private OgretmenlerDAO ogrDAO;

    public List<Ogretmenler> getOgretmenList() {
        this.ogretmenList = this.ogrDAO.list();
        return ogretmenList;
    }

    public OgretmenlerDAO getOgrDAO() {
        if (this.ogrDAO == null) {
            this.ogrDAO = new OgretmenlerDAO();
        }
        return ogrDAO;
    }

    public void setOgrDAO(OgretmenlerDAO ogrDAO) {
        this.ogrDAO = ogrDAO;
    }

    public void setOgretmenList(List<Ogretmenler> ogretmenList) {
        this.ogretmenList = ogretmenList;
    }

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
        this.getDao().insert(this.entity);
        return "/panel/ogrenciler/list";
    }

    public List<Ogrenciler> getRead() {
        return this.getDao().list(page, pageSize);
    }

    public String updateForm(Ogrenciler ogrenci) {
        this.entity = ogrenci;
        return "/panel/ogrenciler/update";
    }

    public String update() {
        this.getDao().update(this.entity);
        return "/panel/ogrenciler/list";
    }

    public void delete(Ogrenciler ogrenci) {
        this.getDao().delete(ogrenci);
    }

    public OgrencilerDAO getDao() {
        if (this.dao == null) {
            this.dao = new OgrencilerDAO();
        }
        return dao;
    }

    public void setDao(OgrencilerDAO dao) {
        this.dao = dao;
    }

    public Ogrenciler getEntity() {
        if (this.entity == null) {
            this.entity = new Ogrenciler();
        }
        return entity;
    }

    public void setEntity(Ogrenciler entity) {

        this.entity = entity;
    }

}
