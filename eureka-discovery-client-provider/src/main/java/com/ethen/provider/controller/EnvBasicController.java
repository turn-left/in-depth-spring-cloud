package com.ethen.provider.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvBasicController implements EnvironmentAware {
    protected Environment env;

    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param env
     */
    @Override
    public void setEnvironment(Environment env) {
        this.env = env;
    }
}
