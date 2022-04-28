/*
 * The MIT License
 *
 * Copyright 2022 Markus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.edv.model.db;

import de.edv.FilmAdapter;
import de.edv.model.exception.ExceptionKino;
import de.edv.model.data.Film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class FilmAdapterDB extends FilmAdapter {

    private DBConnector db;

    public void filmListeDB(DBConnector db) {
        this.db = db;
    }

    public List<Film> get() {
        List<Film> filmList = new ArrayList<Film>();
        try {
            ResultSet res = db.query("SELECT * FROM film;");
            while (res.next()) {
                filmList.add(new Film(res.getInt(1), res.getString(2), String.valueOf(res.getInt(3))));
            }
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filmList;
    }

    public void insert(Film film) {
        try {
            db.queryDML("INSERT INTO film(FilmID, Titel, Jahr, FSK) VALUES "
                    + "('" + film.getFilm_id() + "','" + film.getFilm_titel() + "','" + Integer.parseInt(film.getFilm_description()) + "', '0')");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Film film) {
        try {
            db.queryDML("UPDATE film(FilmID, Titel, Jahr) VALUES "
                    + "('" + film.getFilm_id() + "','" + film.getFilm_titel() + "','" + Integer.parseInt(film.getFilm_description()) + "')");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Film film) {
        try {
            db.queryDML("DELETE FROM film WHERE "
                    + "Titel='" + film.getFilm_titel() + "' AND Jahr=" + Integer.parseInt(film.getFilm_description()) + "");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
