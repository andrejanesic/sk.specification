package com.raf.sk.specification.exceptions;

import com.raf.sk.specification.io.IOManager;

/**
 * Dešava se kada u {@link IOManager} nije registrovan ni jedan drajver, a neka komponenta pokuša da pristupi
 * {@link IOManager#getIODriver()} metodi.
 */
public class IOManagerNoDriverException extends RuntimeException {

    public IOManagerNoDriverException() {
        super("No IODriver registered in IOManager. You must register an IODriver first.");
    }
}
