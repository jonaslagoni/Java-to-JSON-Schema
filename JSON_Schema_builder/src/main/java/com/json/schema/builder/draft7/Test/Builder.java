/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.json.schema.builder.draft7.Test;

/**
 *
 * @author Lagoni
 * @param <T>
 */
public abstract class Builder<T extends Builder<T>> {

    private T parentBuilder;

    public abstract T parent();
}
