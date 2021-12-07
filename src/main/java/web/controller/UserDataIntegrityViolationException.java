package web.controller;

import org.springframework.dao.DataIntegrityViolationException;

public class UserDataIntegrityViolationException extends DataIntegrityViolationException {
    public UserDataIntegrityViolationException(String msg) {
        super(msg);
    } }
