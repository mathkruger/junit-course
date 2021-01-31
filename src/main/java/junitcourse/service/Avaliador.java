package java.junitcourse.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.junitcourse.dominio.Lance;
import java.junitcourse.dominio.Leilao;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public void avaliar(Leilao leilao) {
        for(Lance lance : leilao.getLances()) {
            if(lance.getValor() > maiorDeTodos) {
                maiorDeTodos = lance.getValor();
            }

            if(lance.getValor() < menorDeTodos) {
                menorDeTodos = lance.getValor();
            }

            maiores = new ArrayList<Lance>(leilao.getLances());
            Collections.sort(maiores, new Comparator<Lance>(){

                public int compare(Lance o1, Lance o2) {
                    if(o1.getValor() < o2.getValor()) return 1;
                    if(o1.getValor() > o2.getValor()) return -1;
                    return 0;
                }
                
            });

            maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
        }
    }

    public List<Lance> getTresMaiores() {
        return maiores;
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }
}
