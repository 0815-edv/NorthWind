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
package de.edv.test.sql;

import de.edv.model.db.ActorAdapterDB;
import de.edv.model.db.DBConnector;
import de.edv.model.db.DBConnectorMySQL;
import de.edv.model.exception.ExceptionKino;
import de.edv.model.data.Actor;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Markus
 */
public class ActorTest {

    ActorAdapterDB db;
    Actor a = new Actor()
            .setFirstName("Hans")
            .setLastName("Peters");

    public ActorTest() {
        try {
            DBConnector db = new DBConnectorMySQL("kinoDB", "kino", "kino", 3306, "localhost");
            db.connect();
            this.db = new ActorAdapterDB();
            this.db.actorListeDB(db);
        } catch (ExceptionKino ex) {
            Logger.getLogger(ActorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void TestSELECTActors() {

        assertTrue(db.get().size() != 0 && db.get().get(0) instanceof Actor);
    }

    @Test
    public void TestINSERTActor() {
        try {
            db.insert(a);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(e.getMessage() == "");
        }
    }

    @Test
    public void TestDELETEActor() {
        try {
            db.delete(a);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(e.getMessage() == "");
        }
    }
}
