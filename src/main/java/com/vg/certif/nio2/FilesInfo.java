/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.nio2;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Date;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vladimir
 */
public class FilesInfo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/tmp/test.txt");

        System.out.println("exists:" + Files.exists(path));
        System.out.println("isRegularFile:" + Files.isRegularFile(path));
        System.out.println("size:" + Files.size(path));

        Map<String, Object> attrsMap = Files.readAttributes(path, "*");
        Set<String> keys = attrsMap.keySet();

        System.out.println("\nAll attributes");
        for (String attribute : keys) {
            System.out.println(attribute + ": " + Files.getAttribute(path, attribute));
        }
        System.out.println("\n");

        // metadata
        Object object = Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS); // creation time
        System.out.println("creation:" + object);
        object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
        System.out.println("modif time:" + object);
        object = Files.getAttribute(path, "basic:lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
        System.out.println("last modif time2:" + object);
        object = Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS); // file size
        System.out.println("size:" + object);
        object = Files.getAttribute(path, "posix:group", LinkOption.NOFOLLOW_LINKS); // file size
        System.out.println("group:" + object);
        object = Files.getAttribute(path, "posix:permissions", LinkOption.NOFOLLOW_LINKS); // file size
        System.out.println("permissions:" + object);

        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r--r--");
        Files.setPosixFilePermissions(path, perms);
        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posix.permissions());

        // just setting attributes
        PosixFileAttributeView view2 = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        view2.setPermissions(EnumSet.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE,
                PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_READ));
        PosixFileAttributes attr = view2.readAttributes();
        System.out.println("Group: " + attr.group().getName());
        System.out.println("Owner: " + attr.owner().getName());
        
        posix = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posix.permissions());

        BasicFileAttributes basicAttr = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Creation Time: " + basicAttr.creationTime());

        // just getting information about attributes
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attributes = view.readAttributes();

        System.out.println("\nBasicFileAttributeView");
        System.out.println("Creation Time: " + attributes.creationTime());
        System.out.println("Last Accessed Time: " + attributes.lastAccessTime());
        System.out.println("Last Modified Time: " + attributes.lastModifiedTime());
        System.out.println("File Key: " + attributes.fileKey());
        System.out.println("Directory: " + attributes.isDirectory());
        System.out.println("Other Type of File: " + attributes.isOther());
        System.out.println("Regular File: " + attributes.isRegularFile());
        System.out.println("Symbolic File: " + attributes.isSymbolicLink());
        System.out.println("Size: " + attributes.size());

        System.out.println("\nFiles");
        System.out.println("Last Modified Time: " + Files.getLastModifiedTime(path));
        System.out.println("Readable: " + Files.isReadable(path));
        System.out.println("Writeable: " + Files.isWritable(path));
        System.out.println("Executable: " + Files.isExecutable(path));

        FileTime fileTime = FileTime.fromMillis(new Date().getTime());
        Files.setLastModifiedTime(path, fileTime);

        BasicFileAttributeView v1;
        DosFileAttributeView v2;
        PosixFileAttributeView v6;
        AclFileAttributeView v3;
        FileOwnerAttributeView v4;
        UserDefinedFileAttributeView v5;

        FileSystem fileSystem = FileSystems.getDefault();
        Set<String> fileSystemViews = fileSystem.supportedFileAttributeViews();
        for (String fileSystemView : fileSystemViews) {
            System.out.print(fileSystemView + ":");
        }
        System.out.println("");

    }
}
