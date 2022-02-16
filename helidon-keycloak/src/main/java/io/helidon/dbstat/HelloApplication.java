/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.helidon.dbstat;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Application;
import java.util.Set;

@LoginConfig(authMethod = "MP-JWT")
@ApplicationScoped
public class HelloApplication extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(HelloResource.class);
    }
}
