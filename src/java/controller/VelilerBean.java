package controller;

import DAO.VelilerDAO;
import entity.Veliler;
import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class VelilerBean implements Serializable {

    private VelilerDAO dao;
    private Veliler entity;

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
        this.entity = new Veliler();
        return "/panel/veliler/list.xhtml";
    }

    public List<Veliler> getRead() {
        return this.getDao().list(page, pageSize);
    }

    public String updateForm(Veliler veli) {
        this.entity = veli;
        return "/panel/veliler/update.xhtml";
    }

    public String clearForm() {
        this.entity = new Veliler();
        return "/panel/veliler/list.xhtml";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Veliler();
        return "/panel/veliler/list";
    }

    public void delete(Veliler veli) {
        this.entity = new Veliler();
        this.getDao().delete(veli);
    }

    public VelilerDAO getDao() {
        if (this.dao == null) {
            this.dao = new VelilerDAO();
        }
        return dao;
    }

    public void setDao(VelilerDAO dao) {
        this.dao = dao;
    }

    public Veliler getEntity() {
        if (this.entity == null) {
            this.entity = new Veliler();
        }
        return entity;
    }

    public void setEntity(Veliler veli) {

        this.entity = veli;
    }

}
