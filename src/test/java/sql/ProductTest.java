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

import de.edv.model.data.Product;
import de.edv.model.db.DBConnector;
import de.edv.model.db.DBConnectorMySQL;
import de.edv.model.db.ProductsAdapterDB;
import de.edv.model.exception.NorthwindException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 *
 * @author Markus
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ProductTest {

    ProductsAdapterDB db;
    Product a = new Product(82, "test product", 1, 3, "4x4", 12, 22, 34, 12, false);

    public ProductTest() {
        try {
            DBConnector db = new DBConnectorMySQL("northwind", "kino", "kino", 3306, "localhost");
            db.connect();
            this.db = new ProductsAdapterDB();
            this.db.productListeDB(db);
        } catch (NorthwindException ex) {
            Logger.getLogger(ProductTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void get() {
        assertTrue(!db.get().isEmpty() && db.get().get(0) instanceof Product);
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
