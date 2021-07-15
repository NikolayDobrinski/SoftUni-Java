package com.example.gamestore.model.dto;

import com.example.gamestore.model.entity.BaseEntity;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class GameAddDto {

    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailUrl;
    private String description;
    private String releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer, String thumbnailUrl,
                      String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "[A-Z][a-z]{6,100}", message = "Please enter valid title.")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DecimalMin(value = "0", message = "Please enter valid price.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Positive
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Size(min = 11, max = 11, message = "Please enter valid trailer.")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "(https?).+", message = "Please enter valid Url.")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Size(min = 20, message = "Please enter valid description.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
