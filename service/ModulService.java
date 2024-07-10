package service;

import model.Group;
import model.Modul;

import java.util.ArrayList;
import java.util.List;

public class ModulService implements BaseService<Modul> {
    List<Modul> moduls = new ArrayList<>();

    @Override
    public Modul add(Modul modul) {
        moduls.add(modul);
        return null;
    }

    @Override
    public List<Modul> list() {
        return moduls;
    }

    public List<Modul> modulGroup(Group group){
        List<Modul> moduls1 = new ArrayList<>();
        for (Modul modul : moduls) {
            if (modul.getGroup().equals(group)) {
               moduls1.add(modul);
            }
        }
        return moduls1;
    }
}
