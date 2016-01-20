/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.externaliz;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author vladimir
 */
public class ResourceBundleTest {

    public static void main(String[] args) {
        Locale locale4 = Locale.ITALIAN;
        Locale locale1 = new Locale("ru", "RU");
        Locale locale2 = Locale.forLanguageTag("ro");
        Locale locale3 = new Locale.Builder().setLanguageTag("jp").build();

        ResourceBundle rb = ResourceBundle.getBundle("resources.messages", locale1); // need to create folder resources/messages in the project
        System.out.println("bundle key set" + rb.keySet());
        System.out.println("error =" + rb.getString("error"));

        rb = ResourceBundle.getBundle("com.vg.certif.extern.Messages", locale1);
        System.out.println("error =" + rb.getString("ok"));

        Locale it = new Locale("it", "IT");
        System.out.println(Locale.ITALY.equals(it));

        ResourceBundle rb2 = ResourceBundle.getBundle(
                "Messages",
                it,
                new ResourceBundle.Control() {
                    @Override
                    public List<Locale> getCandidateLocales(
                            String baseName,
                            Locale locale) {
                                if (locale.equals(
                                        new Locale("it", "IT"))) {
                                    return Arrays.asList(
                                            locale,
                                            Locale.ITALIAN,
                                            // no Locale.CHINESE here
                                            Locale.ROOT);
                                }
                                return super.getCandidateLocales(baseName, locale);
                            }
                }
        );
    }
}
