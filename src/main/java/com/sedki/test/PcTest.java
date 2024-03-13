package com.sedki.test;
import com.sedki.dao.PcDao;
import com.sedki.entities.Pc;
public class PcTest {
public static void main(String[] args) {
//créer un objet pc
Pc p = new Pc();
p.setNom_pc("MSI GF 63");
p.setPrixpc(1200);
p.setSpecs("I5 11eme / Gtx 1650");
//ajouter l'objet pc à la BD
PcDao cltDao = new PcDao();
cltDao.ajouter(p);
System.out.println("Appel de la méthode listerTous");
for (Pc p1 : cltDao.listerTous())
System.out.println(p1.getId_pc()+" | nom : "+p1.getNom_pc()+" Prix : "+p1.getPrixpc()+" Specs : "+p1.getSpecs());
System.out.println("Appel de la méthode listerParNom");
for (Pc p1 : cltDao.listerParNom("MSI"))

System.out.println(p1.getId_pc()+" | nom : "+p1.getNom_pc()+" Prix : "+p1.getPrixpc()+" Specs : "+p1.getSpecs());

//tester les autres méthodes de la classe pcDao
p.setPrixpc(500);
cltDao.modifier(p);
for (Pc p1 : cltDao.listerTous())
System.out.println(p1.getId_pc()+" | nom : "+p1.getNom_pc()+" Prix : "+p1.getPrixpc()+" Specs : "+p1.getSpecs());

cltDao.supprimer(p);
for (Pc p1 : cltDao.listerTous())
System.out.println(p1.getId_pc()+" | nom : "+p1.getNom_pc()+" Prix : "+p1.getPrixpc()+" Specs : "+p1.getSpecs());



}
}