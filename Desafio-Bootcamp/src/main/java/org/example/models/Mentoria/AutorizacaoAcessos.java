package org.example.models.Mentoria;

import org.example.models.Devs.Devs;

@FunctionalInterface
public interface AutorizacaoAcessos {

    public boolean validateAccess(Devs dev);

}
