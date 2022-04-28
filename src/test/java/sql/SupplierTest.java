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
package sql;

import de.edv.model.data.Supplier;
import de.edv.model.db.DBConnector;
import de.edv.model.db.DBConnectorMySQL;
import de.edv.model.db.SuppliersAdapterDB;
import de.edv.model.exception.NorthwindException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author Markus
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SupplierTest {

    SuppliersAdapterDB db;
    Supplier a = new Supplier(0, "supplier GmbH", "max musterman", "Prof. Dr.", "Zettachring", "Stuttgart", "DE", "70137", "Deutschland", "0711-1265780", "0711-1235700", "www.test.de");

    public SupplierTest() {
        try {
            DBConnector db = new DBConnectorMySQL("northwind", "kino", "kino", 3306, "localhost");
            db.connect();
            this.db = new SuppliersAdapterDB();
            this.db.supplierListeDB(db);
        } catch (NorthwindException ex) {
            Logger.getLogger(SupplierTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void get() {
        assertTrue(!db.get().isEmpty() && db.get().get(0) instanceof Supplier);
    }

    @Test
    public void insert() {
        db.insert(a);
        assertTrue(true);
    }

    @Test
    @AfterAll
    public void delete() {
        db.delete(a);
        assertTrue(true);
    }
}
