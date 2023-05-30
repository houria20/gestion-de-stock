package com.demo.handlers;

import com.demo.exception.EntityNotFoundException;
import com.demo.exception.ErrorCodes;
import com.demo.exception.InvalidEntityException;
import com.demo.exception.InvalidOperationException;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Collections;

@Provider
@RegisterForReflection // Ajoutez cette annotation pour que Quarkus puisse analyser cette classe à l'exécution
public class RestExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof EntityNotFoundException) {
            return handleEntityNotFoundException((EntityNotFoundException) exception);
        } else if (exception instanceof InvalidOperationException) {
            return handleInvalidOperationException((InvalidOperationException) exception);
        } else if (exception instanceof InvalidEntityException) {
            return handleInvalidEntityException((InvalidEntityException) exception);
        } else if (exception instanceof NotAuthorizedException ) {
            return handleNotAuthorizedException((NotAuthorizedException) exception);
        }

        // Gérer les autres exceptions ici, si nécessaire

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Une erreur s'est produite.")
                .build();
    }

    private Response handleEntityNotFoundException(EntityNotFoundException exception) {
        final Response.Status notFound = Response.Status.NOT_FOUND;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(notFound.getStatusCode())
                .message(exception.getMessage())
                .build();

        return Response.status(notFound)
                .entity(errorDto)
                .build();
    }

    private Response handleInvalidOperationException(InvalidOperationException exception) {
        final Response.Status badRequest = Response.Status.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(badRequest.getStatusCode())
                .message(exception.getMessage())
                .build();

        return Response.status(badRequest)
                .entity(errorDto)
                .build();
    }

    private Response handleInvalidEntityException(InvalidEntityException exception) {
        final Response.Status badRequest = Response.Status.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(badRequest.getStatusCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return Response.status(badRequest)
                .entity(errorDto)
                .build();
    }

    private Response handleNotAuthorizedException(NotAuthorizedException exception) {
        final Response.Status badRequest = Response.Status.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(ErrorCodes.BAD_CREDENTIALS)
                .httpCode(badRequest.getStatusCode())
                .message(exception.getMessage())
                .errors(Collections.singletonList("Login et / ou mot de passe incorrecte"))
                .build();

        return Response.status(badRequest)
                .entity(errorDto)
                .build();
    }
}