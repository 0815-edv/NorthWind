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

import de.edv.ActorAdapter;
import de.edv.model.exception.ExceptionKino;
import de.edv.model.data.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus
 */
public class ActorAdapterDB extends ActorAdapter {

    private DBConnector db;

    public void actorListeDB(DBConnector db) {
        this.db = db;
    }

    public List<Actor> get() {
        List<Actor> actorList = new ArrayList<Actor>();
        try {
            ResultSet res = db.query("SELECT * FROM person;");
            while (res.next()) {
                actorList.add(new Actor(res.getInt(1), res.getString(2), res.getString(3)));
            }
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actorList;
    }

    public void insert(Actor actor) {
        try {
            db.queryDML("INSERT INTO person(PersonID, Name, Vorname) VALUES "
                    + "('" + actor.getActor_id() + "','" + actor.getLast_name() + "','" + actor.getFirst_name() + "')");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Actor actor) {
        try {
            db.queryDML("UPDATE person(PersonID, Name, Vorname) VALUES "
                    + "(" + actor.getActor_id() + ",'" + actor.getLast_name() + "','" + actor.getFirst_name() + "')");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Actor actor) {
        try {
            db.queryDML("DELETE FROM person WHERE "
                    + "Name='" + actor.getLast_name() + "' AND Vorname='" + actor.getFirst_name() + "'");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
