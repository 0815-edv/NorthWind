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
package de.edv.model.data;

/**
 *
 * @author Markus
 */
public class Film {

    private int film_id;
    private String film_titel;
    private String film_description;

    public Film(int film_id, String film_titel, String film_description) {
        this.film_id = film_id;
        this.film_titel = film_titel;
        this.film_description = film_description;
    }

    public Film() {

    }

    // Object Builder
    public Film setFilmTitel(String filmTitel) {
        this.film_titel = filmTitel;
        return this;
    }

    public Film setFilmDescription(String filmDescription) {
        this.film_description = filmDescription;
        return this;
    }

    // Get Set Options
    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_titel() {
        return film_titel;
    }

    public void setFilm_titel(String film_titel) {
        this.film_titel = film_titel;
    }

    public String getFilm_description() {
        return film_description;
    }

    public void setFilm_description(String film_description) {
        this.film_description = film_description;
    }

    @Override
    public String toString() {
        return this.film_titel;
    }
}
