package converter;

import DAO.OgretmenlerDAO;
import entity.Ogretmenler;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "ogretConverter")
public class OgretmenlerConverter implements Converter {

    private OgretmenlerDAO ogrDao;

    public OgretmenlerDAO getOgrDao() {
        if (ogrDao == null) {
            this.ogrDao = new OgretmenlerDAO();
        }
        return ogrDao;
    }

    public void setOgrDao(OgretmenlerDAO ogrDao) {
        this.ogrDao = ogrDao;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getOgrDao().getById(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Ogretmenler ogretmen = (Ogretmenler) arg2;
        return String.valueOf(ogretmen.getOgretmen_id());
    }

}
