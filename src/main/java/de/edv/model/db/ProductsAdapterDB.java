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

import de.edv.ProductsAdapter;
import de.edv.model.exception.ExceptionKino;
import de.edv.model.data.Actor;
import de.edv.model.data.Product;
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
public class ProductsAdapterDB extends ProductsAdapter {

    private DBConnector db;

    public void productListeDB(DBConnector db) {
        this.db = db;
    }

    public List<Product> get() {
        List<Product> productsList = new ArrayList<Product>();
        try {
            ResultSet res = db.query("SELECT * FROM products;");
            while (res.next()) {
                productsList.add(new Product(res.getInt(1), res.getString(2), res.getInt(3),
                        res.getInt(4), res.getInt(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getInt(9), res.getBoolean(10)));
            }
        } catch (ExceptionKino ex) {
            Logger.getLogger(ProductsAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsList;
    }

    public void insert(Product product) {
        try {
            db.queryDML("INSERT INTO products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)"
                    + "VALUES "
                    + "('" + product.getProductName() + "','" + product.getSupplierID() + "','" + product.getCategoryID() + "','" 
                    + product.getQuantityPerUnit() + "','" + product.getUnitPrice() + "','" + product.getUnitsInStock() + "','" 
                    + product.getUnitsOnOrder() + "','" + product.getReorderLevel() + "','" + product.isDiscontinued() + "')");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ProductsAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Actor actor) {
        try {
            db.queryDML("UPDATE person(PersonID, Name, Vorname) VALUES "
                    + "(" + actor.getActor_id() + ",'" + actor.getLast_name() + "','" + actor.getFirst_name() + "')");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ProductsAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Actor actor) {
        try {
            db.queryDML("DELETE FROM person WHERE "
                    + "Name='" + actor.getLast_name() + "' AND Vorname='" + actor.getFirst_name() + "'");
        } catch (ExceptionKino ex) {
            Logger.getLogger(ProductsAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
