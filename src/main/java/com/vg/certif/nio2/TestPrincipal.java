/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

/**
 *
 * @author vladimir
 */
public class TestPrincipal {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/tmp/test.txt");
        FileOwnerAttributeView view6 = Files.getFileAttributeView(path,
                FileOwnerAttributeView.class);
        UserPrincipal userPrincipal = view6.getOwner();

        UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
        userPrincipal = lookupService.lookupPrincipalByName("vladimir");
//        userPrincipal = lookupService.lookupPrincipalByName("root");
        view6.setOwner(userPrincipal);
        System.out.println("UserPrincipal set: " + userPrincipal.getName());

        UserDefinedFileAttributeView view = Files.getFileAttributeView(path,
                UserDefinedFileAttributeView.class);
//         view.write("publishable", Charset.defaultCharset().encode("true")); //  Error writing extended attribute 'publishable': Operation not supported
        System.out.println("Publishable set");

//        String name = "publishable";
//        ByteBuffer buffer = ByteBuffer.allocate(view.size(name));
//        view.read(name, buffer);
//        buffer.flip();
//        String value = Charset.defaultCharset().decode(buffer).toString();
//        System.out.println(value);
    }
}
