package es.brujula.searcher.domain.service.exception;

import es.brujula.searcher.domain.DomainException;

@SuppressWarnings("serial")
public final class ServiceAlreadyExistsException extends RuntimeException implements DomainException {

    private static final String MESSAGE = "ROOM_ALREADY_EXISTS";

    public ServiceAlreadyExistsException(String id) {
        super(id);
    }

    public String getType() {
        return MESSAGE;
    }
}