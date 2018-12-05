package com.shani.sport.beastmode.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "exercises")
public class WgerExercise {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("license_author")
    @Expose
    private String licenseAuthor;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_original")
    @Expose
    private String nameOriginal;
//    @SerializedName("creation_date")
//    @Expose
//    private Object creationDate;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("license")
    @Expose
    private Integer license;
    @SerializedName("category")
    @Expose
    private Integer category;
    @SerializedName("language")
    @Expose
    private Integer language;
//    @SerializedName("muscles")
//    @Expose
//    private List<Integer> muscles;
//    @SerializedName("muscles_secondary")
//    @Expose
//    private List<Integer> musclesSecondary;
//    @SerializedName("equipment")
//    @Expose
//    private List<Integer> equipment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenseAuthor() {
        return licenseAuthor;
    }

    public void setLicenseAuthor(String licenseAuthor) {
        this.licenseAuthor = licenseAuthor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

//    public Object getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Object creationDate) {
//        this.creationDate = creationDate;
//    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

//    public List<Integer> getMuscles() {
//        return muscles;
//    }
//
//    public void setMuscles(List<Integer> muscles) {
//        this.muscles = muscles;
//    }
//
//    public List<Integer> getMusclesSecondary() {
//        return musclesSecondary;
//    }
//
//    public void setMusclesSecondary(List<Integer> musclesSecondary) {
//        this.musclesSecondary = musclesSecondary;
//    }
//
//    public List<Integer> getEquipment() {
//        return equipment;
//    }
//
//    public void setEquipment(List<Integer> equipment) {
//        this.equipment = equipment;
//    }

}