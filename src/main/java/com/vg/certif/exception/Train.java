/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.exception;

/**
 *
 * @author vladimir
 */
public class Train {

    class RanOutOfTrack extends Exception {
    }

    class AnotherTrainComing extends Exception {
    }

    public static void main(String[] args) throws RanOutOfTrack, AnotherTrainComing {
        Train a = new Train();
        try {
            a.drive();
        } catch (RanOutOfTrack e) {
            throw e;
        }
    }

    public void drive() throws RanOutOfTrack, AnotherTrainComing {
        throw new RanOutOfTrack();
    }
}
