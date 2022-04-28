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

import de.edv.SuppliersAdapter;
import de.edv.model.exception.NorthwindException;
import de.edv.model.data.Supplier;
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
public class SuppliersAdapterDB extends SuppliersAdapter {

    private DBConnector db;

    public void supplierListeDB(DBConnector db) {
        this.db = db;
    }

    public List<Supplier> get() {
        List<Supplier> suppliersList = new ArrayList<Supplier>();
        try {
            ResultSet res = db.query("SELECT * FROM suppliers;");
            while (res.next()) {
                suppliersList.add(new Supplier(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8),
                        res.getString(9), res.getString(10), res.getString(11), res.getString(12)));
            }
            db.closeStatement();
        } catch (NorthwindException ex) {
            Logger.getLogger(SuppliersAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SuppliersAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suppliersList;
    }

    public void insert(Supplier supplier) {
        try {
            db.queryDML("INSERT INTO suppliers(CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)"
                    + "VALUES "
                    + "('" + supplier.getCompanyName() + "','" + supplier.getContactName() + "','" + supplier.getContactTitle() + "','"
                    + supplier.getAddress() + "','" + supplier.getCity() + "','" + supplier.getRegion() + "','"
                    + supplier.getPostalCode() + "','" + supplier.getCountry() + "','" + supplier.getPhone() 
                    + "','" + supplier.getFax() + "','" + supplier.getHomePage() + "')");
            db.closeStatement();
        } catch (NorthwindException ex) {
            Logger.getLogger(SuppliersAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Supplier supplier) {
        try {
            db.queryDML("UPDATE suppliers(CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)"
                    + "VALUES "
                    + "('" + supplier.getCompanyName() + "','" + supplier.getContactName() + "','" + supplier.getContactTitle() + "','"
                    + supplier.getAddress() + "','" + supplier.getCity() + "','" + supplier.getRegion() + "','"
                    + supplier.getPostalCode() + "','" + supplier.getCountry() + "','" + supplier.getPhone() 
                    + "','" + supplier.getFax() + "','" + supplier.getHomePage() + "')");
            db.closeStatement();
        } catch (NorthwindException ex) {
            Logger.getLogger(SuppliersAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Supplier supplier) {
        try {
            db.queryDML("DELETE FROM suppliers WHERE "
                    + "ProductID=" + supplier.getSupplierID() + "");
            db.closeStatement();
        } catch (NorthwindException ex) {
            Logger.getLogger(SuppliersAdapterDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
