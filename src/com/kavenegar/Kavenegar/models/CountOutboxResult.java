/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kavenegar.Kavenegar.models;

import com.google.gson.JsonObject;

/**
 * @author mohsen
 */
public class CountOutboxResult extends CountInboxResult {

    private Long sumPart;
    private Long cost;

    public CountOutboxResult(JsonObject json) {
        super(json);
        this.sumPart = json.get("sumpart").getAsLong();
        this.cost = json.get("cost").getAsLong();
    }

    public Long getSumPart() {
        return sumPart;
    }

    public Long getCost() {
        return cost;
    }
}