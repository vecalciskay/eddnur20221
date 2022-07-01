package dao;

import dao.dao.MateriaDao;
import dao.dto.Materia;
import listas.Lista;

import java.util.Date;

public class TestDao {
    public static void main(String[] args) {
        Materia materia = new Materia(1,
                "Matematicas",
                10, new Date());


        System.out.println(materia);

        MateriaDao materiaDao = new MateriaDao();
        /*Materia materia2 = materiaDao.get(1);

        Materia materia3 = new Materia(materia2.id(),
                "Programacion III",
                materia2.creditos(),
                materia2.fechaexamen());
        materiaDao.update(materia3);

        Materia materia4 = materiaDao.get(1);

        System.out.println(materia2);
        System.out.println(materia4);*/

        Lista<Materia> materias = materiaDao.buscar("");
        System.out.println(materias);
    }
}
