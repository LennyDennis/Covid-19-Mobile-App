
package com.example.covid_19.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalCovidStats {

    @SerializedName("cases")
    @Expose
    private Integer cases;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("updated")
    @Expose
    private double updated;
    @SerializedName("active")
    @Expose
    private Integer active;

    /**
     * No args constructor for use in serialization
     */
    public TotalCovidStats() {
    }

    /**
     * @param recovered
     * @param cases
     * @param active
     * @param updated
     * @param deaths
     */
    public TotalCovidStats(Integer cases, Integer deaths, Integer recovered, Integer updated, Integer active) {
        super();
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.updated = updated;
        this.active = active;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public double getUpdated() {
        return updated;
    }

    public void setUpdated(double updated) {
        this.updated = updated;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

}
