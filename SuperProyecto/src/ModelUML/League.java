/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelUML;

import java.util.ArrayList;

/**
 * Esta clase contiene los metodos y constructores de los objetos League
 *
 * @author Sergio Zulueta
 * @version %I% %G%
 * @since 1.0
 */
public class League {

    /**
     * Construccion de los atributos leagueName, matchsets
     */
    private String leagueName;
    private ArrayList<MatchSet> matchsets;

    /**
     * Constructor lleno
     *
     * @param leagueName (requerido) Nombre de la liga
     * @param matchsets (requerido) Lista de los partidos
     */
    public League(String leagueName, ArrayList<MatchSet> matchsets) {
        this.leagueName = leagueName;
        this.matchsets = matchsets;
    }

    /**
     * Constructor solo con el nombre
     *
     * @param leagueName el nombre de la liga
     */
    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     * Es un Get que devuelve el nombre de la liga
     *
     * @return leagueName devuelve el nombre de la liga
     */
    public String getLeagueName() {
        return leagueName;
    }

    /**
     * Es un Set que establece el nombre de la liga
     *
     * @param leagueName el nombre de la liga establecido
     */
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     * Es un Get que devuelve los partidos que se han jugador y se jugaran
     *
     * @return matchsets devuelve los partidos
     */
    public ArrayList<MatchSet> getMatchsets() {
        return matchsets;
    }

    /**
     * Es un Set que establece los partidos que se han jugador y se jugaran
     *
     * @param matchsets establece los partidos
     */
    public void setMatchsets(ArrayList<MatchSet> matchsets) {
        this.matchsets = matchsets;
    }

    /**
     * Añade un MatchSet al objeto League
     *
     * @param mtx el MatchSet a añadir
     */
    public void addMatchSets(MatchSet mtx) {
        if (this.matchsets == null) {
            this.matchsets = new ArrayList();
        }
        this.matchsets.add(mtx);
    }

}
