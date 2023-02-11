/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.nio2;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 *
 * @author vladimir
 */
public class FileSysUpdate {
    
    public static void main(String[] arg) {
        new FileSysUpdate();
    }

    public FileSysUpdate() {
        FileSystem fileSystem = FileSystems.getDefault();
        WatchService watcher = null;
        Path directory = Paths.get("/tmp/subdir");
        WatchEvent.Kind<?>[] events = {ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY};
        try {
            watcher = fileSystem.newWatchService();
            directory.register(watcher, events);
        } catch (IOException ex) {            
            System.err.println(ex.getMessage());
            return;
        }

        while (true) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == OVERFLOW) {
                    continue;
                }
                
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();
                
                System.out.println("Event " + kind + " file " + filename);

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        }
    }
}
